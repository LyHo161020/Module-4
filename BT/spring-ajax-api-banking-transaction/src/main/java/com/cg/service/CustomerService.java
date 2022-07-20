package com.cg.service;

import com.cg.model.Customer;
import com.cg.model.Deposit;
import com.cg.model.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerService extends IGeneralService<Customer> {

    Boolean existsByEmail(String email);
    Boolean existsByPhone(String phone);

    Boolean existsByEmailAndIdIsNot(String email, Long id);
    Boolean existsByPhoneAndIdIsNot(String phone, Long id);

    List<CustomerDTO> findAllCustomerDTO();

    Optional<CustomerDTO> findCustomerDTOBy(Long id);
}
