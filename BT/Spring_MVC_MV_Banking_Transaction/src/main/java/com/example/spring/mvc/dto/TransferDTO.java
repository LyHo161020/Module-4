package com.example.spring.mvc.dto;

import com.example.spring.mvc.utils.ValidDateUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class TransferDTO {
    private String senderId;
    private String senderName;
    private String email;
    private String senderBalance;

    @NotEmpty(message = "Id người nhận không được để trống!")
    @Pattern(regexp = ValidDateUtils.NUMBER_REGEX, message = "Id người nhận không hợp lệ!")
    private String repId;
    private String transactionAmount;

    public TransferDTO() {
    }

    public TransferDTO(String senderId, String senderName, String email, String senderBalance, String repId, String transactionAmount) {
        this.senderId = senderId;
        this.senderName = senderName;
        this.email = email;
        this.senderBalance = senderBalance;
        this.repId = repId;
        this.transactionAmount = transactionAmount;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenderBalance() {
        return senderBalance;
    }

    public void setSenderBalance(String senderBalance) {
        this.senderBalance = senderBalance;
    }

    public String getRepId() {
        return repId;
    }

    public void setRepId(String repId) {
        this.repId = repId;
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
