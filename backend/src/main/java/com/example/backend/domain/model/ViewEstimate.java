package com.example.backend.domain.model;

import lombok.Data;

@Data
public class ViewEstimate {
    private int id;
    private String estimateName;
    private String status;
    private String customerName;
    private String employeeName;
    private int budgetedAmount;
    private int estimateAmount;

    public ViewEstimate (int id, String estimateName, String status, String customerName, String employeeName, int budgetedAmount, int estimateAmount) {
        this.id = id;
        this.estimateName = estimateName;
        this.status = status;
        this.customerName = customerName;
        this.employeeName = employeeName;
        this.budgetedAmount = budgetedAmount;
        this.estimateAmount = estimateAmount;
    }
}
