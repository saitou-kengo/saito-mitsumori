package com.example.backend.domain.repository.dao;

import java.util.List;

import com.example.backend.domain.model.JoinEstimateToMst;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

public interface JoinEstimateToMstDao extends Repository<JoinEstimateToMst, String> {

    //全てのデータを取得
    public List<JoinEstimateToMst> selectAll() throws DataAccessException;

    //指定したIDのデータを取得
    public JoinEstimateToMst selectOne(int id) throws DataAccessException;

    //指定した文字列に部分一致する案件名のデータを取得
    public List<JoinEstimateToMst> selectLikeEstimateNameList(String likeEstimateName) throws DataAccessException;

    //指定した文字列に部分一致する顧客名のデータを取得
    public List<JoinEstimateToMst> selectLikeCustomerNameList(String likeCustomerName) throws DataAccessException;

    //指定した文字列に部分一致する担当者名のデータを取得
    public List<JoinEstimateToMst> selectLikeEmployeeNameList(String likeEmployeeName) throws DataAccessException;

    //指定した文字列に部分一致する担当者名のデータを取得
    public List<JoinEstimateToMst> selectLikeStatusList(String likeStatus) throws DataAccessException;
}
