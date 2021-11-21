package com.example.backend.domain.service;

import java.util.List;

import com.example.backend.domain.model.MstProduct;
import com.example.backend.domain.repository.jdbc.ProductDaoJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ProductService {
    
    @Autowired
    ProductDaoJdbc pDaojdbc;

    public MstProduct getProduct(int cd) {
        return pDaojdbc.selectOne(cd);
    }

    public List<MstProduct> getProductList() {
        return pDaojdbc.selectAll();
    }

    public List<MstProduct> getLikeProductList(String likeStr) {
        return pDaojdbc.selectLikeList(likeStr);
    }
}
