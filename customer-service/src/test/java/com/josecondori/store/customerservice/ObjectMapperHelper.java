package com.josecondori.store.customerservice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

public final class ObjectMapperHelper {

    private final ObjectMapper mapper;
    private static final ObjectMapperHelper INSTANCE = new ObjectMapperHelper();

    private ObjectMapperHelper() {
        this.mapper = new ObjectMapper();
        this.mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        this.mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    public static ObjectMapperHelper getInstance() {
        return INSTANCE;
    }

    public <T> T readValue(final InputStream src, final Class<T> valueType) throws IOException {
        return mapper.readValue(src, valueType);
    }

    public <T> T readValue(final InputStream src, final TypeReference<T> valueTypeRef) throws IOException {
        return (T) mapper.readValue(src, valueTypeRef);
    }
}
