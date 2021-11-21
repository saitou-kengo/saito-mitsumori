package com.example.backend.domain.repository.dao;

import java.util.List;

import com.example.backend.domain.model.Estimate;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

public interface EstimateDao extends Repository {
    //指定したIDのデータを取得
    public Estimate selectOne(int id) throws DataAccessException;

    //指定した文字列に部分一致するデータを取得
    public List<Estimate> selectLikeList(String likeStr) throws DataAccessException;

    //全てのデータを取得
    public List<Estimate> selectAll() throws DataAccessException;

    //指定したデータを登録
    public void insert(Estimate estimate) throws DataAccessException;

    //データ更新
    public void update(Estimate updatedEstimate, int id) throws DataAccessException;

    //指定したIDのデータを削除
    public void delete(int id) throws DataAccessException;
}
