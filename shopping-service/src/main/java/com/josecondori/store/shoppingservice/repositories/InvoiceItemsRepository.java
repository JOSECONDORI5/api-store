package com.josecondori.store.shoppingservice.repositories;

import com.josecondori.store.shoppingservice.models.entities.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItem, Long> {
}
