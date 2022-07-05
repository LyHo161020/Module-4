package com.example.spring.mvc.service;

import com.example.spring.mvc.dto.DepositDTO;
import com.example.spring.mvc.model.Deposit;
import com.example.spring.mvc.repository.IDepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepositsService implements IDepositsService {

    @Autowired
    private IDepositRepository depositRepository;

    @Override
    public List<Deposit> findAll() {
        return depositRepository.findAll();
    }

    @Override
    public Optional<Deposit> findDepositBy(int id) {
        return depositRepository.findById(id);
    }

    @Override
    public Deposit save(Deposit deposit) {
        return depositRepository.save(deposit);
    }

    @Override
    public void deleteDepositBy(int id) {
        depositRepository.deleteById(id);
    }

    @Override
    public DepositDTO findDepositDTOById(int id) {
        return depositRepository.findDepositDTOById(id);
    }
}
