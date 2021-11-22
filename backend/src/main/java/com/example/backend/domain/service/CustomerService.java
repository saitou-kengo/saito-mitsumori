package com.example.backend.domain.service;

import java.util.List;

import com.example.backend.domain.model.MstCustomer;
import com.example.backend.domain.repository.jdbc.CustomerDaoJdbc;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService {
    
    @Autowired
    CustomerDaoJdbc cDaojdbc;

    public MstCustomer getCustomer(int cd) {
        return cDaojdbc.selectOne(cd);
    }

    public List<MstCustomer> getCustomerList() {
        return cDaojdbc.selectAll();
    }

    public List<MstCustomer> getLikeCustomerList(String likeStr) {
        return cDaojdbc.selectLikeList(likeStr);
    }
}
