package com.example.backend.domain.repository.dao;

import java.util.List;

import com.example.backend.domain.model.MstCustomer;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

public interface CustomerDao extends Repository {
    //指定したIDのデータを取得
    public MstCustomer selectOne(int cd) throws DataAccessException;

    //指定した文字列に部分一致するデータを取得
    public List<MstCustomer> selectLikeList(String str) throws DataAccessException;
    
    //全てのデータを取得
    public List<MstCustomer> selectAll() throws DataAccessException;
}
