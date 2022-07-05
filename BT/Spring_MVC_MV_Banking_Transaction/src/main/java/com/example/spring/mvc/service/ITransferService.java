package com.example.spring.mvc.service;

import com.example.spring.mvc.model.Transfer;

import java.util.List;

public interface ITransferService {
    List<Transfer> findAll();

    Transfer findTransferBy(Long id);

    Transfer save(Transfer transfer);


    void deleteTransferBy(Long id);
}
