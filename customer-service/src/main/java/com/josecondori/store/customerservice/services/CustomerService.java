package com.josecondori.store.customerservice.services;

import com.josecondori.store.customerservice.models.entities.Customer;
import com.josecondori.store.customerservice.models.entities.Region;

import java.util.List;

public interface CustomerService {
    List<Customer> findCustomerAll();
    List<Customer> findCustomersByRegion(Region region);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Customer deleteCustomer(Customer customer);
    Customer getCustomer(Long id);

}
