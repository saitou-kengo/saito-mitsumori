package com.example.backend.domain.service;

import java.util.List;

import com.example.backend.domain.model.MstProducts;
import com.example.backend.domain.repository.MstProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * MstProduct（商品）のサービス
 */
@Transactional
@Service
public class MstProductsService {
    
    @Autowired
    private MstProductsRepository mPRepository;

    //指定した商品CDの商品を取得
    public MstProducts getProduct(int cd) {
        return mPRepository.getById(cd);
    }

    //全商品リストを取得
    public List<MstProducts> getProductList() {
        return mPRepository.findAll();
    }

    //指定した商品名に部分一致する全商品リストを取得
    public List<MstProducts> getProductListByNameContaining(String name) {
        return mPRepository.findByNameContaining(name);
    }

}
