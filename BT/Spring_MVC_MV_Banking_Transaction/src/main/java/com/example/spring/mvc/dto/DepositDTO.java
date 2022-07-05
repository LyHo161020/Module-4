package com.example.spring.mvc.dto;

import javax.validation.constraints.*;

public class DepositDTO {
    private int id;

    private String fullName;
    private String email;
    private long balance;

    private long transactionAmount;

    public DepositDTO() {
    }

    public DepositDTO(int id, String fullName, String email, long balance, long transactionAmount) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.balance = balance;
        this.transactionAmount = transactionAmount;
    }

    public DepositDTO(int id, String fullName, long balance, long transactionAmount) {
        this.id = id;
        this.fullName = fullName;
        this.balance = balance;
        this.transactionAmount = transactionAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
