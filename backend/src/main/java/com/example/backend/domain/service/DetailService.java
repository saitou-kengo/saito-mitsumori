package com.example.backend.domain.service;

import java.util.List;

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

    public EstimateDetail getProduct(int id) {
        return dDaojdbc.selectOne(id);
    }

    public List<EstimateDetail> getProductList() {
        return dDaojdbc.selectAll();
    }

    public void insert(EstimateDetail detail) {
        dDaojdbc.insert(detail);
    }

    public void update(EstimateDetail updatedDetail, int id) {
        dDaojdbc.update(updatedDetail, id);
    }

    public void delete(int id) {
        dDaojdbc.delete(id);
    }
}
