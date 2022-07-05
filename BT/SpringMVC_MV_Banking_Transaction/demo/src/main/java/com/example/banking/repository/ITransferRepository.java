package com.example.banking.repository;

import com.example.banking.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ITransferRepository extends JpaRepository<Transfer, Integer> {
    List<Transfer> findAll();

    Transfer findTransferBy(Long id);

    Transfer save(Transfer transfer);


    void deleteTransferBy(Long id);
}
