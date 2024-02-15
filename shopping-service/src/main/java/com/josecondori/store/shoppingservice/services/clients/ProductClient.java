package com.josecondori.store.shoppingservice.services.clients;

import com.josecondori.store.shoppingservice.models.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "product-service", path = "/products")
public interface ProductClient {

    @GetMapping(path = "/{id}")
    ResponseEntity<Product> getProduct(@PathVariable(name = "id") Long id);

    @PutMapping(path = "/{id}/stock")
    ResponseEntity<Product> updateStockProduct(@PathVariable Long id, @RequestParam(name = "quantity") Double quantity);
}
