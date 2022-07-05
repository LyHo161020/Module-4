package com.example.banking.service;

import com.example.banking.model.Customer;
import com.example.banking.model.Deposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;

@Service
public class DepositsService implements IDepositsService{

    @Autowired
    private IDepositsService depositsService;

    @Override
    public List<Deposit> findAll() {
        return depositsService.findAll();
    }

    @Override
    public Deposit findDepositBy(Long id) {
        return depositsService.findDepositBy(id);
    }

    @Override
    public Deposit save(Deposit deposit) {
        return depositsService.save(deposit);
    }

    @Override
    public void deleteDepositBy(Long id) {
        depositsService.deleteDepositBy(id);
    }
}
