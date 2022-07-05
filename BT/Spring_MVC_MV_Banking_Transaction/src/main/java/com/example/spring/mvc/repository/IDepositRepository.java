package com.example.spring.mvc.repository;

import com.example.spring.mvc.dto.DepositDTO;
import com.example.spring.mvc.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface IDepositRepository extends JpaRepository<Deposit,Integer> {
    @Query("SELECT NEW com.example.spring.mvc.dto.DepositDTO (c.id, c.fullName, c.balance, d.transactionAmount) FROM Customer AS c JOIN Deposit AS d ON c.id = d.customerId WHERE c.id = :id")
    DepositDTO findDepositDTOById(@Param("id") Integer id);
}
