package com.josecondori.store.shoppingservice.services.clients;

import com.josecondori.store.shoppingservice.models.entities.Customer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service", path = "/customers", fallbackFactory = CustomerHystrixFallbackFactory.class)
@Qualifier("customer-service")
public interface CustomerClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<Customer> getCustomer(@PathVariable("id") long id);

}
