package com.cg.model.dto;


import com.cg.model.Customer;
import com.cg.model.Transfer;
import com.cg.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

public class TransferDTO {

    public static int fees = 10;
    @Autowired
    private CustomerService customerService;


    private Long senderId;
    private String recipientId;

    @Min(value = 50, message = "Số tiền giao dịch tối thiếu là 50$")
    @Max(value = 100000, message = "Số tiền giao dịch tối đa là 100.000$")
    private String transferAmount;

    public TransferDTO() {
    }

    public TransferDTO(Long senderId, String recipientId, String transferAmount) {
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.transferAmount = transferAmount;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(String recipientId) {
        this.recipientId = recipientId;
    }

    public String getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(String transferAmount) {
        this.transferAmount = transferAmount;
    }

    public Transfer toTransfer(TransferDTO transferDTO, Customer sender, Customer recipient) {
        Transfer newTransfer = new Transfer();

        newTransfer.setSender(sender);
        newTransfer.setRecipient(recipient);
        newTransfer.setFees(fees);
        newTransfer.setTransferAmount(new BigDecimal(transferDTO.getTransferAmount()));
        return newTransfer;
    }
}
