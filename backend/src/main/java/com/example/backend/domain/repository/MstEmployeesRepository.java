package com.example.backend.domain.repository;

import java.util.List;

import com.example.backend.domain.model.MstEmployees;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MstEmployeesRepository extends JpaRepository<MstEmployees, Integer> {

    List<MstEmployees> findByNameLike(String name);

}
