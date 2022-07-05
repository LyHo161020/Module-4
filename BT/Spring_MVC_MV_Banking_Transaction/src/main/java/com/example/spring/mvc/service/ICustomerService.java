package com.example.spring.mvc.service;

import com.example.spring.mvc.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();


    Optional<Customer> findCustomerBy(Integer id);

    Customer save(Customer customer);

    void remove(Integer id);
}
