package com.example.backend.domain.service;

import java.util.List;

import com.example.backend.domain.model.MstEmployees;
import com.example.backend.domain.repository.MstEmployeesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * MstEmployee（担当者）のサービス
 */
@Transactional
@Service
public class MstEmployeesService {
    
    @Autowired
    private MstEmployeesRepository mERepository;

    //指定した担当者CDの顧客を取得
    public MstEmployees getEmployee(int cd) {
        return mERepository.getById(cd);
    }

    //全担当者リストを取得
    public List<MstEmployees> getEmployeeList() {
        return mERepository.findAll();
    }

    //指定した担当者名に部分一致する全担当者リストを取得
    public List<MstEmployees> getEmployeeListByNameContaining(String name) {
        return mERepository.findByNameContaining(name);
    }

}
