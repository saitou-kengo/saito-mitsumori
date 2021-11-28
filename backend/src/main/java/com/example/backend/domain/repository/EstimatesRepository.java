package com.example.backend.domain.repository;

import com.example.backend.domain.model.Estimates;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstimatesRepository extends JpaRepository<Estimates, Integer> {
    
}
