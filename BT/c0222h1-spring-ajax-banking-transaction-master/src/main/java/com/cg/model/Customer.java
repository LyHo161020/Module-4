package com.cg.model;

import com.cg.model.dto.CustomerDTO;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;


@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 25, message = "Name too long")
    @Column(name = "full_name")
    private String fullName;

    @NotEmpty(message = "The email address is required.")
    @Email(message = "The email address is invalid.")
    @Size(min = 5, max = 50, message = "The length of email must be between 5 and 50 characters.")
    @Column(unique = true, nullable = false)
    private String email;

    private String phone;
    private String address;

    @Digits(integer = 12, fraction = 0)
    @Column(updatable = false)
    private BigDecimal balance;


    @OneToMany(targetEntity = Deposit.class, fetch = FetchType.EAGER)
    private Set<Deposit> deposits;

    @OneToMany(targetEntity = Withdraw.class, fetch = FetchType.EAGER)
    private Set<Withdraw> withdraws;

    @OneToMany(targetEntity = Transfer.class, fetch = FetchType.EAGER)
    private Set<Transfer> sender;

    @OneToMany(targetEntity = Transfer.class, fetch = FetchType.EAGER)
    private Set<Transfer> recipient;

    public Customer() {
    }

    public Customer(Long id, @Size(max = 25, message = "Tên quá dài") String fullName, @NotEmpty(message = "The email address is required.") @Email(message = "The email address is invalid.") @Size(min = 5, max = 50, message = "The length of email must be between 5 and 50 characters.") String email, String phone, String address, @Digits(integer = 12, fraction = 0) BigDecimal balance, Set<Deposit> deposits, Set<Withdraw> withdraws, Set<Transfer> sender, Set<Transfer> recipient) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.balance = balance;
        this.deposits = deposits;
        this.withdraws = withdraws;
        this.sender = sender;
        this.recipient = recipient;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Set<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(Set<Deposit> deposits) {
        this.deposits = deposits;
    }

    public Set<Withdraw> getWithdraws() {
        return withdraws;
    }

    public void setWithdraws(Set<Withdraw> withdraws) {
        this.withdraws = withdraws;
    }

    public Set<Transfer> getSender() {
        return sender;
    }

    public void setSender(Set<Transfer> sender) {
        this.sender = sender;
    }

    public Set<Transfer> getRecipient() {
        return recipient;
    }

    public void setRecipient(Set<Transfer> recipient) {
        this.recipient = recipient;
    }

    public CustomerDTO toCustomerDTO() {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(this.id);
        customerDTO.setFullName(this.fullName);
        customerDTO.setEmail(this.email);
        customerDTO.setPhone(this.phone);
        customerDTO.setAddress(this.address);
        customerDTO.setBalance(this.balance);

        return customerDTO;
    }
}
