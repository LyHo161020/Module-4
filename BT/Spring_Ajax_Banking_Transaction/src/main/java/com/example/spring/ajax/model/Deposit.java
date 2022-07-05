package com.example.spring.ajax.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "deposits")
public class Deposit extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
//    private Date createAt;
//    private int createBy;
//    private boolean deleted;
//    private Date updateAt;
//    private int updateBy;

    @ManyToOne
    @JoinColumn
    private Customer customer;
    private long transactionAmount;

    public Deposit(){
    }

    public Deposit(Customer customer, long transactionAmount) {
        this.customer = customer;
        this.transactionAmount = transactionAmount;
    }

    public Deposit(int id, Customer customer, long transactionAmount) {
        this.id = id;
//        this.createAt = createAt;
//        this.createBy = createBy;
//        this.deleted = deleted;
//        this.updateAt = updateAt;
//        this.updateBy = updateBy;
        this.customer = customer;
        this.transactionAmount = transactionAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Date getCreateAt() {
//        return createAt;
//    }
//
//    public void setCreateAt(Date createAt) {
//        this.createAt = createAt;
//    }
//
//    public int getCreateBy() {
//        return createBy;
//    }
//
//    public void setCreateBy(int createBy) {
//        this.createBy = createBy;
//    }
//
//    public boolean isDeleted() {
//        return deleted;
//    }
//
//    public void setDeleted(boolean deleted) {
//        this.deleted = deleted;
//    }
//
//    public Date getUpdateAt() {
//        return updateAt;
//    }
//
//    public void setUpdateAt(Date updateAt) {
//        this.updateAt = updateAt;
//    }
//
//    public int getUpdateBy() {
//        return updateBy;
//    }
//
//    public void setUpdateBy(int updateBy) {
//        this.updateBy = updateBy;
//    }

    public Customer getCustomerId() {
        return customer;
    }

    public void setCustomerId(Customer customer) {
        this.customer = customer;
    }

    public long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
