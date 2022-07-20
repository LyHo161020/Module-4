package com.cg.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    private Long senderId;
    private String senderName;
    private String email;
    private Long recipientId;
    private String recipientName;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date createdOn;

    @JsonFormat(pattern = "HH:mm:ss", timezone = "Asia/Ho_Chi_Minh")
    private Date createdAt;

    private BigDecimal balance;
    private BigDecimal transferAmount;
    private int fees;
    private BigDecimal feesAmount;
    private BigDecimal transactionAmount;

}
