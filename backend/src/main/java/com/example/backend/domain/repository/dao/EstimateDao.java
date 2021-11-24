package com.example.backend.domain.repository.dao;

import com.example.backend.domain.model.Estimate;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

public interface EstimateDao extends Repository<Estimate, String> {

    //指定したデータを登録
    public void insert(Estimate estimate) throws DataAccessException;

    //データ更新
    public void update(Estimate updatedEstimate, int id) throws DataAccessException;

    //指定したIDのデータを削除
    public void delete(int id) throws DataAccessException;
}
