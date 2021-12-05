package com.example.backend.domain.repository;

import java.util.List;

import com.example.backend.domain.model.Estimates;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Estiate（見積）のリポジトリー
 */
public interface EstimatesRepository extends JpaRepository<Estimates, Integer> {
    
    public List<Estimates> findByIdLike(int id);

    public List<Estimates> findByNameContaining(String name);

    public List<Estimates> findByStatusContaining(String status);

    public List<Estimates> findByCustomerCd(int customerCd);

    public List<Estimates> findByEmployeeCd(int employeeCd);

}
