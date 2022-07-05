package com.example.spring.mvc.repository;


import com.example.spring.mvc.dto.WithdrawDTO;
import com.example.spring.mvc.model.Withdraw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IWithdrawRepository extends JpaRepository<Withdraw, Integer> {
    @Query("SELECT NEW com.example.spring.mvc.dto.DepositDTO (c.id, c.fullName, c.balance, w.transactionAmount) FROM Customer AS c JOIN Withdraw AS w ON c.id = w.customerId WHERE c.id = :id")
    WithdrawDTO findWithdrawDTOById(@Param("id") Integer id);
}
