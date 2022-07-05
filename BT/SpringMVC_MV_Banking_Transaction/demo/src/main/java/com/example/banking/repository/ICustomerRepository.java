package com.example.banking.repository;

import com.example.banking.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAll();

    Customer findCustomerBy(Long id);

    Customer save(Customer customer);

    void deleteCustomerBy(Long id);
}
