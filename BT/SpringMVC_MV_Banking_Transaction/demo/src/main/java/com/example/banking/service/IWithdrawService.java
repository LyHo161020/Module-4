package com.example.banking.service;

import com.example.banking.model.Customer;
import com.example.banking.model.Withdraw;

import java.sql.SQLException;
import java.util.List;

public interface IWithdrawService {
    List<Withdraw> findAll();

    Withdraw findWithdrawBy(Long id);

    Withdraw save(Withdraw withdraw);


    void deleteWithdrawBy(Long id);
}
