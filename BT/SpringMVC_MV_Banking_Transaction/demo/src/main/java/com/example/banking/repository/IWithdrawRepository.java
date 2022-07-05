package com.example.banking.repository;

import com.example.banking.model.Withdraw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWithdrawRepository extends JpaRepository<Withdraw,Integer> {
    List<Withdraw> findAll();

    Withdraw findWithdrawBy(Long id);

    Withdraw save(Withdraw withdraw);


    void deleteWithdrawBy(Long id);
}
