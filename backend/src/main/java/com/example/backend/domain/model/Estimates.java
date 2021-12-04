package com.example.backend.domain.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * Estimate（見積）のモデル
 */
@Table(name = "estimates")
@Entity
@Builder
@Data
public class Estimates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "amount")
    private int amount;
    @Column(name = "budgeted_amount")
    private int budgetedAmount;
    @Column(name = "customer_cd")
    private int customerCd;
    @Column(name = "employee_cd")
    private int employeeCd;
    @Column(name = "date")
    private Date date;
    @Column(name = "status")
    private String status;
    @Column(name = "order_id")
    private int orderId;

    @Tolerate
    public Estimates() {}

}
