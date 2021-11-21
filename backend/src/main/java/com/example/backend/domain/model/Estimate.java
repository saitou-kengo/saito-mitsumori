package com.example.backend.domain.model;

import lombok.Data;

@Data
public class Estimate {
    private int id;
    private String estimate_name;
    private int estimate_amount;
    private int budgeted_amount;
    private int customer_cd;
    private int employee_cd;
    private String estimate_date;
    private String status;
    private int order_id;
}
