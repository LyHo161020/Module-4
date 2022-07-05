package com.example.spring.mvc.dto;

public class WithdrawDTO {
    private int id;

    private String fullName;
    private long balance;

    private String transactionAmount;

    public WithdrawDTO() {
    }

    public WithdrawDTO(int id, String fullName, long balance, String transactionAmount) {
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

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
