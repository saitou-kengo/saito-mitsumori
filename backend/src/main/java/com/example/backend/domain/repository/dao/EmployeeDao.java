package com.example.backend.domain.repository.dao;

import java.util.List;

import com.example.backend.domain.model.MstEmployee;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

public interface EmployeeDao extends Repository {
        
        //指定したIDのデータを取得
        public MstEmployee selectOne(int cd) throws DataAccessException;

        //指定した文字列に部分一致するデータを取得
        public List<MstEmployee> selectLikeList(String str) throws DataAccessException;
        
        //全てのデータを取得
        public List<MstEmployee> selectAll() throws DataAccessException;
}
