package com.example.backend.domain.service;

import java.util.List;

import com.example.backend.domain.model.JoinDetailToMst;
import com.example.backend.domain.repository.jdbc.JoinDetailToMstDaoJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class JoinDetailToMstService {
    
    @Autowired
    JoinDetailToMstDaoJdbc jJdbc;

    public List<JoinDetailToMst> getAllJoinDetailToMstList() {
        return jJdbc.selectAll();
    }

    public List<JoinDetailToMst> getAllJoinDetailToMstListByEstimateId(int estimateId) {
        return jJdbc.selectAllByEstimateId(estimateId);
    }
}
