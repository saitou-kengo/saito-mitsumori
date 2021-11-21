package com.example.backend.domain.model;

import lombok.Data;

@Data
public class EstimateDetail {
    private int id;
    private int sub_id;
    private int estimate_id;
    private int product_cd;
    private int quantity;
}
