package com.josecondori.store.customerservice.models.constants.enums;

import lombok.Getter;

@Getter
public enum EnumCustomerState {
    CREATED("CREATED"),
    UPDATED("UPDATED"),
    DELETED("DELETED");

    private final String description;

    EnumCustomerState(String description) {
        this.description = description;
    }
}
