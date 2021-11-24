package com.example.backend.domain.service;

import java.util.Map;

import com.example.backend.domain.model.EstimateDetail;
import com.example.backend.domain.repository.jdbc.DetailDaoJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class DetailService {
    
    @Autowired
    DetailDaoJdbc dDaojdbc;

    public void insert(Map<String, String> detail) {
        int productCd = Integer.parseInt(detail.get("productCd"));
        int quantity = Integer.parseInt(detail.get("quantity"));
        dDaojdbc.insert(new EstimateDetail(productCd, quantity));
    }

    public void update(Map<String, String> updatedDetail, int id) {
        int productCd = Integer.parseInt(updatedDetail.get("productCd"));
        int quantity = Integer.parseInt(updatedDetail.get("quantity"));
        dDaojdbc.update(new EstimateDetail(productCd, quantity), id);
    }

    public void delete(int id) {
        dDaojdbc.delete(id);
    }
}
