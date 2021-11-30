package com.example.backend.domain.repository;

import java.util.List;

import com.example.backend.domain.model.Estimates;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstimatesRepository extends JpaRepository<Estimates, Integer> {
    
    public List<Estimates> findByIdLike(int id);

    public List<Estimates> findByNameLike(String name);

    public List<Estimates> findByStatusLike(String status);

    public List<Estimates> findByCustomerCdLike(int customerCd);

    public List<Estimates> findByEmployeeCdLike(int employeeCd);

}
