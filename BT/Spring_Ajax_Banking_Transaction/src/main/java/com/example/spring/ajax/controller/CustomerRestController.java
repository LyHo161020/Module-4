package com.example.spring.ajax.controller;


import com.example.spring.ajax.model.Customer;
import com.example.spring.ajax.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {
    @Autowired
    private ICustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<?> doCreate(@RequestBody Customer customer) {
        customer.setId(0);
        customer.setBalance(BigDecimal.ZERO);
        try {
            customer = customerService.save(customer);

            return  new ResponseEntity<>(customer, HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity<>("Server không xử lý được", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}