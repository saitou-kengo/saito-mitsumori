package com.example.backend.domain.model;

import lombok.Data;

@Data
public class Estimate {
    private int id;
    private String estimateName;
    private int estimateAmount;
    private int budgetedAmount;
    private int customerCd;
    private int employeeCd;
    private String estimateDate;
    private String status;
    private int orderId;
}
