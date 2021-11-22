package com.example.backend.domain.model;

import lombok.Data;

@Data
public class JoinEstimateToMst {
    private int id;
    private String estimateName;
    private int estimateAmount;
    private int budgetedAmount;
    private int customerCd;
    private int employeeCd;
    private String estimateDate;
    private String status;
    private int orderId;
    private String customerName;
    private String employeeName;
}
