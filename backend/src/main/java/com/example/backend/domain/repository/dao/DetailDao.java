package com.example.backend.domain.repository.dao;

import java.util.List;

import com.example.backend.domain.model.EstimateDetail;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

public interface DetailDao extends Repository {
    
    //指定したIDのデータを取得
    public EstimateDetail selectOne(int cd) throws DataAccessException;

    //全てのデータを取得
    public List<EstimateDetail> selectAll() throws DataAccessException;

    //指定したデータを登録
    public void insert(EstimateDetail estimate) throws DataAccessException;

    //データ更新
    public void update(EstimateDetail updatedDetail, int id) throws DataAccessException;

    //指定したIDのデータを削除
    public void delete(int id) throws DataAccessException;
}
