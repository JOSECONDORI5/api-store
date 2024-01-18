package com.josecondori.store.shoppingservice.repositories;

import com.josecondori.store.shoppingservice.EntityStubs;
import com.josecondori.store.shoppingservice.models.entities.Invoice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.io.IOException;

@DataJpaTest
class InvoiceRepositoryTest {

    @Autowired
    private InvoiceRepository invoiceRepository;

    private Invoice invoice;

    @BeforeEach
    public void setup() throws IOException {
        invoice = EntityStubs.getInstance().getInputInvoice();
        invoiceRepository.save(invoice);
    }

    @Test
    void test() {
        Invoice invoiceFound = invoiceRepository.findByNumberInvoice(invoice.getNumberInvoice());

        Assertions.assertThat(invoiceFound).isNotNull();
        Assertions.assertThat(invoiceFound.getCustomerId()).isEqualTo(invoice.getCustomerId());
    }
}
