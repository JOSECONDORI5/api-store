package com.josecondori.store.shoppingservice.services.impl;

import com.josecondori.store.shoppingservice.models.constants.enums.EnumInvoiceState;
import com.josecondori.store.shoppingservice.models.entities.Customer;
import com.josecondori.store.shoppingservice.models.entities.Invoice;
import com.josecondori.store.shoppingservice.models.entities.Product;
import com.josecondori.store.shoppingservice.repositories.InvoiceRepository;
import com.josecondori.store.shoppingservice.services.InvoiceService;
import com.josecondori.store.shoppingservice.services.clients.CustomerClient;
import com.josecondori.store.shoppingservice.services.clients.ProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Qualifier("customer-service")
    private final CustomerClient customerClient;

    private final ProductClient productClient;

    private final CircuitBreakerFactory circuitBreakerFactory;

    @Override
    public List<Invoice> findInvoiceAll() {
        return invoiceRepository.findAll();
    }


    @Override
    public Invoice createInvoice(Invoice invoice) {
        Invoice invoiceDB = invoiceRepository.findByNumberInvoice(invoice.getNumberInvoice());
        if (invoiceDB != null) {
            return invoiceDB;
        }
        invoice.setState(EnumInvoiceState.CREATED.getDescription());
        invoiceDB = invoiceRepository.save(invoice);
        invoiceDB.getItems().forEach(invoiceItem -> {
            invoiceItem.setPrice(null);
            Double quantity = circuitBreakerFactory.create("getPrice").run(invoiceItem::getPrice, p -> BigDecimal.ZERO.doubleValue());
            productClient.updateStockProduct(invoiceItem.getProductId(), quantity * -1);
        });
        return invoiceDB;
    }


    @Override
    public Invoice updateInvoice(Invoice invoice) {
        Invoice invoiceDB = getInvoice(invoice.getId());
        if (invoiceDB == null) {
            return null;
        }
        invoiceDB.setCustomerId(invoice.getCustomerId());
        invoiceDB.setDescription(invoice.getDescription());
        invoiceDB.setNumberInvoice(invoice.getNumberInvoice());
        invoiceDB.getItems().clear();
        invoiceDB.setItems(invoice.getItems());
        invoiceDB.setState(EnumInvoiceState.UPDATED.getDescription());
        return invoiceRepository.save(invoiceDB);
    }


    @Override
    public Invoice deleteInvoice(Invoice invoice) {
        Invoice invoiceDB = getInvoice(invoice.getId());
        if (invoiceDB == null) {
            return null;
        }
        invoiceDB.setState(EnumInvoiceState.DELETED.getDescription());
        return invoiceRepository.save(invoiceDB);
    }

    @Override
    public Invoice getInvoice(Long id) {
        Invoice invoice = invoiceRepository.findById(id).orElse(null);
        if (null != invoice) {
            Customer customer = customerClient.getCustomer(invoice.getCustomerId()).getBody();
            invoice.setCustomer(customer);
            invoice.getItems()
                    .forEach(invoiceItem -> {
                        Product product = productClient.getProduct(invoiceItem.getProductId()).getBody();
                        invoiceItem.setProduct(product);
                    });
            invoice.setItems(invoice.getItems());
        }
        return invoice;
    }
}
