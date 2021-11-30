package com.example.backend.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Table(name = "estimate_details")
@Entity
@Builder
@Data
public class EstimateDetails {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "sub_id")
    private int subId;
    @Column(name = "estimate_id")
    private int estimateId;
    @Column(name = "product_cd")
    private int productCd;
    @Column(name = "quantity")
    private int quantity;

    @Tolerate
    public EstimateDetails() {}
}
