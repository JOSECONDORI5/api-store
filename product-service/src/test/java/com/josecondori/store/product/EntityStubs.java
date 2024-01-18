package com.josecondori.store.product;

import com.josecondori.store.product.models.entities.Product;

import java.io.IOException;

public final class EntityStubs {

    private static final EntityStubs INSTANCE = new EntityStubs();

    private final ObjectMapperHelper objectMapperHelper = ObjectMapperHelper.getInstance();

    private EntityStubs() {
    }

    public static EntityStubs getInstance() {
        return INSTANCE;
    }

    public Product getInputProduct() throws IOException {
        return objectMapperHelper.readValue(Thread.currentThread().getContextClassLoader().getResourceAsStream("mock/inputProduct.json"), Product.class);
    }

}
