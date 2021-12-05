package com.example.backend.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * MstCustomer（顧客）のモデル
 */
@Table(name = "mst_customers")
@Entity
@Builder
@Data
public class MstCustomers {
    @Id
    @Column(name = "cd")
    private int cd;
    @Column(name = "name")
    private String name;
    
    @Tolerate
    public MstCustomers() {}
}
