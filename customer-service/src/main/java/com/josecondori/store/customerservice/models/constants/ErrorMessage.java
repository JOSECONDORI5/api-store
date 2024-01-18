package com.josecondori.store.customerservice.models.constants;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Builder
@Getter
@Setter
public final class ErrorMessage {
    private String code;
    private List<Map<String, String>> messages;
    public static String formatMessages(BindingResult result, String code) {
        List<Map<String, String>> errors = result.getFieldErrors().stream()
                .map(err -> {
                    Map<String, String> error = new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;
                }).toList();

        ErrorMessage errorMessage = ErrorMessage.builder()
                .code(code)
                .messages(errors)
                .build();
        return toJson(errorMessage);
    }

    public static String formatMessages(BindingResult result, Integer code) {
        return formatMessages(result, code.toString());
    }

    public static String formatMessages(BindingResult result, HttpStatus status) {
        return formatMessages(result, status.value());
    }

    private static String toJson(ErrorMessage errorMessage) {
        ObjectMapper mapper = new ObjectMapper();
        String json = "";
        try {
            json = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        return json;
    }
}

