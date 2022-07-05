package com.example.spring.ajax.service;

import com.example.spring.ajax.model.Customer;
import com.example.spring.ajax.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerServiceImpl implements ICustomerService{
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Optional<Customer> findCustomerBy(Integer id) {
        return Optional.empty();
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }
}
