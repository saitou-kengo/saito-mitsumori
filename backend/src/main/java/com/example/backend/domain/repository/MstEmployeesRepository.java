package com.example.backend.domain.repository;

import java.util.List;

import com.example.backend.domain.model.MstEmployees;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MstEmployeesRepository extends JpaRepository<MstEmployees, Integer> {

    public List<MstEmployees> findByNameLike(String name);

    public MstEmployees findByName(String name);
}
