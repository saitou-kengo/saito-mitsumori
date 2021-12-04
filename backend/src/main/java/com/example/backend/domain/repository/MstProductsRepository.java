package com.example.backend.domain.repository;

import java.util.List;

import com.example.backend.domain.model.MstProducts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * MstProduct（商品）のリポジトリー
 */
public interface MstProductsRepository extends JpaRepository<MstProducts, Integer> {

    public List<MstProducts> findByNameContaining(String name);

}
