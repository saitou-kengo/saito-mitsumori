package com.example.backend.domain.repository;

import java.util.List;

import com.example.backend.domain.model.MstCustomers;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MstCustomersRepository extends JpaRepository<MstCustomers, Integer> {

    public List<MstCustomers> findByNameLike(String name);

    public MstCustomers findByName(String name);
}
