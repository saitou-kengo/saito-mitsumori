package com.example.backend.domain.repository.dao;

import java.util.List;

import com.example.backend.domain.model.MstProduct;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;

public interface ProductDao extends Repository {

        //指定したIDのデータを取得
        public MstProduct selectOne(int cd) throws DataAccessException;

        //指定した文字列に部分一致するデータを取得
        public List<MstProduct> selectLikeList(String likeStr) throws DataAccessException;
        
        //全てのデータを取得
        public List<MstProduct> selectAll() throws DataAccessException;
}
