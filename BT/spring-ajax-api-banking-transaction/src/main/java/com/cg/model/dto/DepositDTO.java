package com.cg.model.dto;

import com.cg.model.BaseEntity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class DepositDTO extends BaseEntity {
    private Long id;
    private Long customerId;

    @NotEmpty(message = "Vui lòng nhập số tiền muốn giao dịch!")
    @Min(value = 50,message = "Số tiền giao dịch tối thiểu là 50$")
    @Max(value = 100000, message = "Số tiền giao dịch tối đa là 100.000$")
    private String transactionAmount;
}
