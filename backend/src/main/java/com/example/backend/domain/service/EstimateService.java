package com.example.backend.domain.service;

import java.util.List;

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

    public Estimate getEstimate(int id) {
        return eDaojdbc.selectOne(id);
    }

    public List<Estimate> getEstimateList() {
        return eDaojdbc.selectAll();
    }

    public List<Estimate> getLikeEstimateList(String likeStr) {
        return eDaojdbc.selectLikeList(likeStr);
    }

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
