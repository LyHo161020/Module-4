package com.example.banking.service;

import com.example.banking.model.Withdraw;
import com.example.banking.repository.IWithdrawRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WithdrawService implements IWithdrawService{

    @Autowired
    private IWithdrawRepository withdrawRepository;

    @Override
    public List<Withdraw> findAll() {
        return withdrawRepository.findAll();
    }

    @Override
    public Withdraw findWithdrawBy(Long id) {
        return withdrawRepository.findWithdrawBy(id);
    }

    @Override
    public Withdraw save(Withdraw withdraw) {
        return withdrawRepository.save(withdraw);
    }

    @Override
    public void deleteWithdrawBy(Long id) {
        withdrawRepository.deleteWithdrawBy(id);
    }
}
