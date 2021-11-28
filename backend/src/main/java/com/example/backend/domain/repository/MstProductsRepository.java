package com.example.backend.domain.repository;

import java.util.List;

import com.example.backend.domain.model.MstProducts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MstProductsRepository extends JpaRepository<MstProducts, Integer> {

    List<MstProducts> findByNameLike(String name);

}
