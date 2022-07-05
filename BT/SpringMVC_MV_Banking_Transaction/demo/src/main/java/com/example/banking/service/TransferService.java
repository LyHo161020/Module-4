package com.example.banking.service;

import com.example.banking.model.Customer;
import com.example.banking.model.Transfer;
import com.example.banking.model.TransferInfo;
import com.example.banking.repository.ITransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class TransferService implements ITransferService{

    @Autowired
    private ITransferRepository transferRepository;

    @Override
    public List<Transfer> findAll() {
        return transferRepository.findAll();
    }

    @Override
    public Transfer findTransferBy(Long id) {
        return transferRepository.findTransferBy(id);
    }

    @Override
    public Transfer save(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    @Override
    public void deleteTransferBy(Long id) {
        transferRepository.deleteTransferBy(id);
    }
}
