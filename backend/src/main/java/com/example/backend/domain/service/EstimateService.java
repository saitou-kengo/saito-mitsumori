package com.example.backend.domain.service;

import java.util.Map;

import com.example.backend.domain.model.Estimate;
import com.example.backend.domain.repository.jdbc.EstimateDaoJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class EstimateService {

    @Autowired
    EstimateDaoJdbc eDaojdbc;

    public void insert(Map<String, String> estimate) {
        String estimateName = estimate.get("estimateName");
        int estimateAmount = Integer.parseInt(estimate.get("estimateAmount"));
        int budgetedAmount = Integer.parseInt(estimate.get("budgetedAmount"));
        int customerCd = Integer.parseInt(estimate.get("customerCd"));
        int employeeCd = Integer.parseInt(estimate.get("employeeCd"));
        String status = estimate.get("status");
        int orderId = Integer.parseInt(estimate.get("orderId"));
        eDaojdbc.insert(new Estimate(
            estimateName,
            estimateAmount,
            budgetedAmount,
            customerCd,
            employeeCd,
            status,
            orderId));
    }

    public void update(Map<String, String> updatedEstimate, int id) {
        String estimateName = updatedEstimate.get("estimateName");
        int estimateAmount = Integer.parseInt(updatedEstimate.get("estimateAmount"));
        int budgetedAmount = Integer.parseInt(updatedEstimate.get("budgetedAmount"));
        int customerCd = Integer.parseInt(updatedEstimate.get("customerCd"));
        int employeeCd = Integer.parseInt(updatedEstimate.get("employeeCd"));
        String status = updatedEstimate.get("status");
        int orderId = Integer.parseInt(updatedEstimate.get("orderId"));
        eDaojdbc.update(new Estimate(
            estimateName,
            estimateAmount,
            budgetedAmount,
            customerCd,
            employeeCd,
            status,
            orderId),
            id);
    }

    public void delete(int id) {
        eDaojdbc.delete(id);
    }
}
