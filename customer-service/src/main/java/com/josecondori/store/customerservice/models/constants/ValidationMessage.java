package com.josecondori.store.customerservice.models.constants;

public final class ValidationMessage {

    public static final String DOCUMENT_NOT_EMPTY = "The document number cannot be not empty";
    public static final String DOCUMENT_LENGTH = "The document number must be 8 digits";
    public static final String FIRSTNAME_NOT_EMPTY = "The firstname cannot be not empty";
    public static final String LASTNAME_NOT_EMPTY = "The lastname cannot be not empty";
    public static final String EMAIL_NOT_EMPTY = "The email cannot be not empty";
    public static final String REGION_NOT_EMPTY = "The region cannot be not empty";
    public static final String EMAIL_INVALID = "Email invalid";

    private ValidationMessage() {}
}
