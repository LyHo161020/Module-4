package com.example.spring.mvc.model;


import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Tên không được để trống!")
    @Pattern(regexp = "^([A-Za-z]+[A-Za-z]*[ ]?)+$", message = "Tên chỉ bao gồm các kí tự a-z A-Z!")
    @Length (max = 255, message = "Tên chỉ được chứa tối đa 255 kí tự!")
    private String fullName;

    @NotBlank(message = "Email không được để trống!")
    @Pattern(regexp = "^[A-Za-z0-9_]+@[A-Za-z0-9_]+\\.[A-Za-z]{2,3}$",message = "Email chỉ được phép chưa các kí tự a-z A-Z 0-9 và _ ")
    @Length (max = 255, message = "Email chỉ được chứa tối đa 255 kí tự!")
    private String email;

    @NotBlank(message = "Số điện thoại không được để trống!")
    @Size(min = 9, max = 20,message = "Số điện thoại gồm từ 9-20 số!")
    private String phone;
    @NotBlank(message = "Địa chỉ không được để trống!")
    @Length (max = 255, message = "Địa chỉ chỉ được chứa tối đa 255 kí tự!")
    private String address;

    private long balance;

    public Customer(){
    }

    public Customer(int id, String fullName, String email, String phone, String address, long balance) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.balance = balance;
    }

    public Customer(int id, String fullName, String email, String phone, String address) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Customer(String fullName, String email, String phone, String address, long balance) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.balance = balance;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}

