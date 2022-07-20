package com.cg.repository;

import com.cg.model.Deposit;
import com.cg.model.dto.DepositDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {
}
