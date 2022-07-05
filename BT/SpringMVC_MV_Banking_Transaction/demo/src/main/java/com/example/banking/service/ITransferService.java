package com.example.banking.service;

import com.example.banking.model.Customer;
import com.example.banking.model.Transfer;
import com.example.banking.model.TransferInfo;

import java.sql.SQLException;
import java.util.List;

public interface ITransferService {
    List<Transfer> findAll();

    Transfer findTransferBy(Long id);

    Transfer save(Transfer transfer);


    void deleteTransferBy(Long id);
}
