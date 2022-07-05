package com.example.banking.repository;

import com.example.banking.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IDepositRepository extends JpaRepository<Deposit,Integer> {
    List<Deposit> findAll();

    Deposit findDepositBy(Long id);

    Deposit save(Deposit deposit);


    void deleteDepositBy(Long id);
}
