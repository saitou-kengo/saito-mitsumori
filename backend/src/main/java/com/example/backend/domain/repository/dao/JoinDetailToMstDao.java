package com.example.backend.domain.repository.dao;

import java.util.List;

import com.example.backend.domain.model.JoinDetailToMst;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

public interface JoinDetailToMstDao extends Repository {
    
    //全てのデータを取得
    public List<JoinDetailToMst> selectAll() throws DataAccessException;

    //指定した見積IDの全てのデータを取得
    public List<JoinDetailToMst> selectAllByEstimateId(int estimateId) throws DataAccessException;

}
