package com.example.backend.domain.repository;

import java.util.List;

import com.example.backend.domain.model.MstEmployees;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * MstEmployee（担当者）のリポジトリー
 */
public interface MstEmployeesRepository extends JpaRepository<MstEmployees, Integer> {

    public List<MstEmployees> findByNameContaining(String name);

    public MstEmployees findByName(String name);
}
