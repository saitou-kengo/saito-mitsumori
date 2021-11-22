package com.example.backend.domain.service;

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

    public void insert(Estimate estimate) {
        eDaojdbc.insert(estimate);
    }

    public void update(Estimate updatedEstimate, int id) {
        eDaojdbc.update(updatedEstimate, id);
    }

    public void delete(int id) {
        eDaojdbc.delete(id);
    }
}
