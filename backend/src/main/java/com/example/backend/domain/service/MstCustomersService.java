package com.example.backend.domain.service;

import java.util.List;

import com.example.backend.domain.model.MstCustomers;
import com.example.backend.domain.repository.MstCustomersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class MstCustomersService {
    
    @Autowired
    private MstCustomersRepository mCRepository;

    public MstCustomers getCustomer(int cd) {
        return mCRepository.findById(cd).orElseThrow();
    }

    public List<MstCustomers> getCustomerList() {
        return mCRepository.findAll();
    }

    public List<MstCustomers> getLikeCustomerList(String name) {
        return mCRepository.findByNameLike(name);
    }

}
