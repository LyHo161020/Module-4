package com.cg.model.dto;

import com.cg.model.Customer;
import com.cg.model.Location;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;

public class CustomerDTO {
    private Long id;

    @NotBlank(message = "Tên không được để trống!")
    @NotNull(message = "tên không được để trống!")
    @Size(min = 5, max = 50, message = "Tên phải bao gồm ít nhất 5 kí tự và không vượt quá 50 kí tự!")
    private String fullName;

    @NotBlank(message = "Email không được để trống!")
    @NotNull(message = "email không được để trống!")
    @Size(min = 10, max = 50, message = "Email phải bao gồm ít nhất 10 kí tự và không vượt quá 50 kí tự!")
    @Email(message = "Email không hợp lệ! VD: holy1610@gmail.com")
    private String email;

    @NotBlank(message = "Số điện thoại không được để trống!")
    private String phone;

    @Digits(integer = 12, fraction = 0)
    private BigDecimal balance;



    @Valid
    private Location location;

    public CustomerDTO() {
    }



    public CustomerDTO(Long id, String fullName, String email, String phone, BigDecimal balance, Location location) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
        this.location = location;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Customer toCustomer(){
        Customer customer = new Customer();
        customer.setFullName(this.fullName);
        customer.setEmail(this.email);
        customer.setPhone(this.phone);
        customer.setLocation(this.location);

        return customer;
    }
}
