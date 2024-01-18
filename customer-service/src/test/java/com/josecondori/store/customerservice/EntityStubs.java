package com.josecondori.store.customerservice;

import com.josecondori.store.customerservice.models.entities.Customer;

import java.io.IOException;

public final class EntityStubs {

    private static final EntityStubs INSTANCE = new EntityStubs();

    private final ObjectMapperHelper objectMapperHelper = ObjectMapperHelper.getInstance();

    private EntityStubs() {
    }

    public static EntityStubs getInstance() {
        return INSTANCE;
    }

    public Customer getInputCustomer() throws IOException {
        return objectMapperHelper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream("mock/inputCustomer.json"), Customer.class);
    }

}
