package com.josecondori.store.product.repositories;

import com.josecondori.store.product.EntityStubs;
import com.josecondori.store.product.models.entities.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.io.IOException;
import java.util.List;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    private Product product;

    @BeforeEach
    public void setup() throws IOException {
        product = EntityStubs.getInstance().getInputProduct();
        productRepository.save(product);
    }

    @Test
    void whenFindByCategory_thenReturnListProduct() {
        List<Product> products = productRepository.findByCategory(product.getCategory());

        Assertions.assertThat(products).hasSize(1);
    }
}
