package com.example.backend.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * MstProduct（商品）のモデル
 */
@Table(name = "mst_products")
@Entity
@Builder
@Data
public class MstProducts {
    @Id
    @Column(name = "cd")
    private int cd;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;

    @Tolerate
    public MstProducts() {}
}
