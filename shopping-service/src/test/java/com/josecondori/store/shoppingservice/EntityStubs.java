package com.josecondori.store.shoppingservice;

import com.josecondori.store.shoppingservice.models.entities.Invoice;

import java.io.IOException;

public final class EntityStubs {

    private static final EntityStubs INSTANCE = new EntityStubs();

    private final ObjectMapperHelper objectMapperHelper = ObjectMapperHelper.getInstance();

    private EntityStubs() {
    }

    public static EntityStubs getInstance() {
        return INSTANCE;
    }

    public Invoice getInputInvoice() throws IOException {
        return objectMapperHelper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream("mock/inputInvoice.json"), Invoice.class);
    }

}
