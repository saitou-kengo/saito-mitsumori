package com.example.backend.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

/**
 * MstEmployee（担当者）のマスタ
 */
@Table(name = "mst_employees")
@Entity
@Builder
@Data
public class MstEmployees {
    @Id
    @Column(name = "cd")
    private int cd;
    @Column(name = "name")
    private String name;

    @Tolerate
    public MstEmployees() {}
}
