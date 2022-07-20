package com.cg.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;


@Entity
@Table(name = "withdraws")
public class Withdraw extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @Digits(integer = 12, fraction = 0)
    @Column(name = "transaction_amount", nullable= false)
//    @NotBlank(message = "Số tiền giao dịch không được để trống!")
    @Min(value = 50, message = "Số tiền giao dịch tối thiếu là 50$")
    @Max(value = 100000, message = "Số tiền giao dịch tối đa là 100.000$")
    private BigDecimal transactionAmount;

    public Withdraw() {
    }

    public Withdraw(Long id, Customer customer, @Digits(integer = 12, fraction = 0) BigDecimal transactionAmount) {
        this.id = id;
        this.customer = customer;
        this.transactionAmount = transactionAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
