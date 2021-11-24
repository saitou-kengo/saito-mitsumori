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

    public Estimate(
        String estimateName,
        int estimateAmount,
        int budgetedAmount,
        int customerCd,
        int employeeCd,
        String status) {
            this.estimateName = estimateName;
            this.estimateAmount = estimateAmount;
            this.budgetedAmount = budgetedAmount;
            this.customerCd = customerCd;
            this.employeeCd = employeeCd;
            this.status = status;
    }
}
