package com.cg.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;


@Entity
@Table(name = "transfers")
public class Transfer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Customer sender;

    @ManyToOne
    @JoinColumn(name = "recipient_id")
    private Customer recipient;

    @Digits(integer = 12, fraction = 0)
    @Column(name = "transfer_amount", nullable= false)
    private BigDecimal transferAmount;

    @Column(nullable= false)
    private int fees;

    @Digits(integer = 12, fraction = 0)
    @Column(name = "fees_amount", nullable= false)
    private BigDecimal feesAmount;

    @Digits(integer = 12, fraction = 0)
    @Column(name = "transaction_amount", nullable= false)
    private BigDecimal transactionAmount;

    public Transfer() {
    }

    public Transfer(Long id, Customer sender, Customer recipient, @Digits(integer = 12, fraction = 0) BigDecimal transferAmount, int fees, @Digits(integer = 12, fraction = 0) BigDecimal feesAmount, @Digits(integer = 12, fraction = 0) BigDecimal transactionAmount) {
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
        this.transferAmount = transferAmount;
        this.fees = fees;
        this.feesAmount = feesAmount;
        this.transactionAmount = transactionAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getSender() {
        return sender;
    }

    public void setSender(Customer sender) {
        this.sender = sender;
    }

    public Customer getRecipient() {
        return recipient;
    }

    public void setRecipient(Customer recipient) {
        this.recipient = recipient;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public BigDecimal getFeesAmount() {
        return feesAmount;
    }

    public void setFeesAmount(BigDecimal feesAmount) {
        this.feesAmount = feesAmount;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
