package com.josecondori.store.shoppingservice.services.clients;

import com.josecondori.store.shoppingservice.models.entities.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomerHystrixFallbackFactory implements FallbackFactory<CustomerClient> {
    @Override
    public CustomerClient create(Throwable cause) {
        log.error("An exception occurred when calling the CustomerClient", cause);
        return id -> {
            Customer customer = Customer.builder()
                    .firstName("none")
                    .lastName("none")
                    .email("none")
                    .photoUrl("none").build();
            return ResponseEntity.ok(customer);
        };
    }
}
