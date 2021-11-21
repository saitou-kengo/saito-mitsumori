package com.example.backend.domain.service;

import java.util.List;

import com.example.backend.domain.model.MstEmployee;
import com.example.backend.domain.repository.jdbc.EmployeeDaoJdbc;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService {
    
    @Autowired
    EmployeeDaoJdbc eDaojdbc;

    public MstEmployee getProduct(int cd) {
        return eDaojdbc.selectOne(cd);
    }

    public List<MstEmployee> getProductList() {
        return eDaojdbc.selectAll();
    }

    public List<MstEmployee> getLikeProductList(String likeStr) {
        return eDaojdbc.selectLikeList(likeStr);
    }
}
