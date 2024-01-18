package com.josecondori.store.shoppingservice.models.constants.enums;

import lombok.Getter;

@Getter
public enum EnumInvoiceState {
    CREATED("CREATED"),
    UPDATED("UPDATED"),
    DELETED("DELETED");

    private final String description;

    EnumInvoiceState(String description) {
        this.description = description;
    }
}
