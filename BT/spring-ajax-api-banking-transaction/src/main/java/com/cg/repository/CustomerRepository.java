package com.cg.repository;

import com.cg.model.Customer;
import com.cg.model.Deposit;
import com.cg.model.dto.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT NEW com.cg.model.dto.CustomerDTO " +
            "(c.id , " +
            "c.fullName, " +
            "c.email, " +
            "c.phone, " +
            "c.address, " +
            "c.balance) " +
            "FROM Customer AS c")
    List<CustomerDTO> findAllCustomerDTO();

    @Query("SELECT NEW com.cg.model.dto.CustomerDTO (" +
            "c.id, " +
            "c.fullName, " +
            "c.email, " +
            "c.phone, " +
            "c.address, " +
            "c.balance) " +
            "FROM Customer AS c WHERE c.id = :id")
    Optional<CustomerDTO> findCustomerDTOBy(@Param("id") Long id);
    Boolean existsByEmail(String email);
    Boolean existsByPhone(String phone);

    Boolean existsByEmailAndIdIsNot(String email, Long id);
    Boolean existsByPhoneAndIdIsNot(String phone, Long id);

}
