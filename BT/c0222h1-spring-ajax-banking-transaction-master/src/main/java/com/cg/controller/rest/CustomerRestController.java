package com.cg.controller.rest;


import com.cg.model.Customer;
import com.cg.service.CustomerService;
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
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<?> doCreate(@RequestBody Customer customer) {

        customer.setId(0L);
        customer.setBalance(BigDecimal.ZERO);

        Boolean existEmail = customerService.existsByEmail(customer.getEmail());

        if (existEmail) {
            return new ResponseEntity<>("Trùng email", HttpStatus.CONFLICT);
        }

        try {
            customer = customerService.save(customer);

            return new ResponseEntity<>(customer.toCustomerDTO(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Server ko xử lý được", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
