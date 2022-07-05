package com.example.banking.service;

import com.example.banking.model.Customer;
import com.example.banking.model.Deposit;

import java.sql.SQLException;
import java.util.List;

public interface IDepositsService {
    List<Deposit> findAll();

    Deposit findDepositBy(Long id);

    Deposit save(Deposit deposit);


    void deleteDepositBy(Long id);
}
