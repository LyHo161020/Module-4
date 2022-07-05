package com.example.spring.ajax.service;

import com.example.spring.ajax.model.Customer;

import java.util.List;
import java.util.Optional;

public interface IGeneralService <T>{
    List<Customer> findAll();


    Optional<Customer> findCustomerBy(Integer id);

    Customer save(Customer customer);

    void remove(Integer id);
}

