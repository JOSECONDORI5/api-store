package com.josecondori.store.product.repositories;

import com.josecondori.store.product.models.entities.Category;
import com.josecondori.store.product.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(Category Category);
}
