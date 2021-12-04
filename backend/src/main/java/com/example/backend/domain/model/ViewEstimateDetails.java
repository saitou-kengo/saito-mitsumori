package com.example.backend.domain.model;

import lombok.Data;

/**
 * 画面に表示する見積明細リストのモデル（データベースとは紐づかない）
 */
@Data
public class ViewEstimateDetails {
    private int id;
    private int subId;
    private String productName;
    private int price;
    private int quantity;
    private int totalPrice;

    public ViewEstimateDetails(int id, int subId, String productName, int price, int quantity) {
        this.id = id;
        this.subId = subId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        totalPrice = price * quantity;
    }
}
