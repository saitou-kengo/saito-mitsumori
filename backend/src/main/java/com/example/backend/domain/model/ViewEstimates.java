package com.example.backend.domain.model;

import lombok.Data;

@Data
public class ViewEstimates {
    private int id;
    private String estimateName;
    private String status;
    private String customerName;
    private String employeeName;
    private int amount;
    private int budgetedAmount;

    public ViewEstimates(int id, String estimateName, String status, String customerName, String employeeName, int amount, int budgetedAmount) {
        this.id = id;
        this.estimateName = estimateName;
        this.status = status;
        this.customerName = customerName;
        this.employeeName = employeeName;
        this.amount = amount;
        this.budgetedAmount = budgetedAmount;
    }
}
