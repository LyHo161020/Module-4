package com.example.spring.mvc.service;

import com.example.spring.mvc.model.Withdraw;

import java.util.List;

public interface IWithdrawService {
    List<Withdraw> findAll();

    Withdraw findWithdrawBy(Long id);

    Withdraw save(Withdraw withdraw);


    void deleteWithdrawBy(Long id);
}
