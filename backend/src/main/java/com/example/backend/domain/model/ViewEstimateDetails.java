package com.example.backend.domain.model;

import lombok.Data;

@Data
public class ViewEstimateDetails {
    private int id;
    private String productName;
    private int price;
    private int quantity;
    private int totalPrice;

    public ViewEstimateDetails(int id, String productName, int price, int quantity) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        totalPrice = price * quantity;
    }
}
