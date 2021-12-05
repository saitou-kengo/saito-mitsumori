package com.example.backend.domain.repository;

import java.util.List;

import com.example.backend.domain.model.EstimateDetails;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * EstimateDetail（見積明細）のリポジトリー
 */
public interface EstimateDetailsRepository extends JpaRepository<EstimateDetails, Integer> {

    public List<EstimateDetails> findByEstimateId(int id);

    public List<EstimateDetails> deleteByEstimateId(int estimateId);

}
