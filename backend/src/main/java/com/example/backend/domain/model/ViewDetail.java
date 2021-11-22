package com.example.backend.domain.model;

import lombok.Data;

@Data
public class ViewDetail {
    private int subId;
    private String productName;
    private int price;
    private int quantity;
    private int totalPrice;

    public ViewDetail(int subId, String productName, int price, int quantity, int totalPrice) {
        this.subId = subId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}
