package com.example.backend.domain.model;

import lombok.Data;

@Data
public class JoinDetailToMst {
    private int id;
    private int subId;
    private int estimateId;
    private int productCd;
    private int quantity;
    private String productName;
    private int price;
    private int totalPrice;
}
