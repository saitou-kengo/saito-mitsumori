package com.example.backend.domain.service;

import java.util.List;

import com.example.backend.domain.model.MstEmployee;
import com.example.backend.domain.repository.jdbc.EmployeeDaoJdbc;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService {
    
    @Autowired
    EmployeeDaoJdbc eDaojdbc;

    public MstEmployee getEmployee(int cd) {
        return eDaojdbc.selectOne(cd);
    }

    public List<MstEmployee> getEmployeeList() {
        return eDaojdbc.selectAll();
    }

    public List<MstEmployee> getLikeEmployeeList(String likeStr) {
        return eDaojdbc.selectLikeList(likeStr);
    }
}
