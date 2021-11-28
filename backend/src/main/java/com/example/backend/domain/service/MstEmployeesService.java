package com.example.backend.domain.service;

import java.util.List;

import com.example.backend.domain.model.MstEmployees;
import com.example.backend.domain.repository.MstEmployeesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class MstEmployeesService {
    
    @Autowired
    private MstEmployeesRepository mERepository;

    public MstEmployees getEmployee(int cd) {
        return mERepository.findById(cd).orElseThrow();
    }

    public List<MstEmployees> getEmployeeList() {
        return mERepository.findAll();
    }

    public List<MstEmployees> getLikeEmployeeList(String name) {
        return mERepository.findByNameLike(name);
    }

}
