package com.example.spring.mvc.repository;

import com.example.spring.mvc.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface ITransferRepository extends JpaRepository<Transfer, Integer> {

}
