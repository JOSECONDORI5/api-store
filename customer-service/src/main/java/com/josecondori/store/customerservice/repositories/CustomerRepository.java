package com.josecondori.store.customerservice.repositories;

import com.josecondori.store.customerservice.models.entities.Customer;
import com.josecondori.store.customerservice.models.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByNumberId(String numberId);
    List<Customer> findByLastName(String lastName);
    List<Customer> findByRegion(Region region);
}
