package com.example.spring.mvc.service;

import com.example.spring.mvc.dto.DepositDTO;
import com.example.spring.mvc.model.Deposit;

import java.util.List;
import java.util.Optional;

public interface IDepositsService {
    List<Deposit> findAll();

    Optional<Deposit> findDepositBy(int id);

    Deposit save(Deposit deposit);


    void deleteDepositBy(int id);

    DepositDTO findDepositDTOById(int id);
}
