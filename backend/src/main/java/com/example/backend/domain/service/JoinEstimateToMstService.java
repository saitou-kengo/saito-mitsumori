package com.example.backend.domain.service;

import java.util.List;

import com.example.backend.domain.model.JoinEstimateToMst;
import com.example.backend.domain.repository.jdbc.JoinEstimateToMstDaoJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class JoinEstimateToMstService {
    
    @Autowired
    JoinEstimateToMstDaoJdbc jDaoJdbc;

    public List<JoinEstimateToMst> getAllJoinEstimateToMstList() {
        return jDaoJdbc.selectAll();
    }

    public JoinEstimateToMst getEstimate(int id) {
        return jDaoJdbc.selectOne(id);
    }

    public List<JoinEstimateToMst> getLikeEstimateNameList(String likeEstimateName) {
        return jDaoJdbc.selectLikeEstimateNameList(likeEstimateName);
    }

    public List<JoinEstimateToMst> getLikeCustomerNameList(String likeCustomerName) {
        return jDaoJdbc.selectLikeCustomerNameList(likeCustomerName);
    }

    public List<JoinEstimateToMst> getLikeEmployeeNameList(String likeEmployeeName) {
        return jDaoJdbc.selectLikeEmployeeNameList(likeEmployeeName);
    }

    public List<JoinEstimateToMst> getLikeStatusList(String likeStatus) {
        return jDaoJdbc.selectLikeStatusList(likeStatus);
    }
}
