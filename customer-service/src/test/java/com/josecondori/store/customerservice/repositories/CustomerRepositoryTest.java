package com.josecondori.store.customerservice.repositories;

import com.josecondori.store.customerservice.EntityStubs;
import com.josecondori.store.customerservice.models.entities.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.io.IOException;

@DataJpaTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;
    private Customer customer;

    @BeforeEach
    public void setup() throws IOException {
        customer = EntityStubs.getInstance().getInputCustomer();
        customerRepository.save(customer);
    }

    @Test
    void whenFindByNumberId_thenReturnCustomer() {
        Customer customerFound = customerRepository.findByNumberId(customer.getNumberId());

        Assertions.assertThat(customer).isNotNull();
        Assertions.assertThat(customer.getId()).isEqualTo(customerFound.getId());
    }

}
