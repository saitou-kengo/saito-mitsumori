package com.example.backend.domain.service;

import java.util.List;

import com.example.backend.domain.model.MstProducts;
import com.example.backend.domain.repository.MstProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class MstProductsService {
    
    @Autowired
    private MstProductsRepository mPRepository;

    public MstProducts getProduct(int cd) {
        return mPRepository.findById(cd).orElseThrow();
    }

    public List<MstProducts> getProductList() {
        return mPRepository.findAll();
    }

    public List<MstProducts> getLikeProductList(String name) {
        return mPRepository.findByNameLike(name);
    }

}
