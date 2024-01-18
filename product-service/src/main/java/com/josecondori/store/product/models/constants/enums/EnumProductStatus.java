package com.josecondori.store.product.models.constants.enums;

import lombok.Getter;

@Getter
public enum EnumProductStatus {
    CREATED("CREATED"),
    UPDATED("UPDATED"),
    DELETED("DELETED");

    private final String description;

    EnumProductStatus(String description) {
        this.description = description;
    }
}
