package com.example.backend.domain.service;

import java.util.List;

import com.example.backend.domain.model.MstCustomers;
import com.example.backend.domain.repository.MstCustomersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * MstCustomer（顧客）のサービス
 */
@Transactional
@Service
public class MstCustomersService {
    
    @Autowired
    private MstCustomersRepository mCRepository;

    //指定した顧客CDの顧客を取得
    public MstCustomers getCustomer(int cd) {
        return mCRepository.getById(cd);
    }

    //全顧客リストを取得
    public List<MstCustomers> getCustomerList() {
        return mCRepository.findAll();
    }

    //指定した顧客名に部分一致する全顧客リストを取得
    public List<MstCustomers> getCustomerListByNameContaining(String name) {
        return mCRepository.findByNameContaining(name);
    }

}
