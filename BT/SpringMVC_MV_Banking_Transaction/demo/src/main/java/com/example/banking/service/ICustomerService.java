package com.example.banking.service;

import com.example.banking.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer findCustomerBy(Long id);

    Customer save(Customer customer);

    void remove(Long id);
}
