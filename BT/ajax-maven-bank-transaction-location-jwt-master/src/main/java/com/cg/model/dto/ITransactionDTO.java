package com.cg.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public interface ITransactionDTO {
    int getId();
    Long getSenderId();
    String getSenderName();
    Long getRecipientId();
    String getRecipientName();

    @JsonFormat(pattern = "dd-MM-yyyy")
    Date getCreatedOn();

    @JsonFormat(pattern = "HH:mm:ss", timezone = "Asia/Ho_Chi_Minh")
    Date getCreatedAt();

    BigDecimal getTransferAmount();
    int getFees();
    BigDecimal getFeesAmount();
    BigDecimal getTransactionAmount();
}
