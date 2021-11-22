package com.example.backend.domain.model;

import lombok.Data;

@Data
public class EstimateDetail {
    private int id;
    private int subId;
    private int estimateId;
    private int productCd;
    private int quantity;
}
