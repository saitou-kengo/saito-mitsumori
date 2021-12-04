package com.example.backend.domain.model;

import lombok.Data;

/**
 * 画面に表示する見積リストのモデル（データベースとは紐づかない）
 */
@Data
public class ViewEstimates {
    private int id;
    private String estimateName;
    private String status;
    private int customerCd;
    private String customerName;
    private int employeeCd;
    private String employeeName;
    private int amount;
    private int budgetedAmount;

    public ViewEstimates(
        int id,
        String estimateName,
        String status,
        int customerCd,
        String customerName, 
        int employeeCd,
        String employeeName,
        int amount,
        int budgetedAmount) {
            this.id = id;
            this.estimateName = estimateName;
            this.status = status;
            this.customerCd = customerCd;
            this.customerName = customerName;
            this.employeeCd = employeeCd;
            this.employeeName = employeeName;
            this.amount = amount;
            this.budgetedAmount = budgetedAmount;
    }
}
