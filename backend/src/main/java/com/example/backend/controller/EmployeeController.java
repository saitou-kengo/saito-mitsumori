package com.example.backend.controller;

import java.util.List;

import com.example.backend.domain.model.MstEmployee;
import com.example.backend.domain.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService eService;

    @GetMapping("/api/v1/employees")
    public List<MstEmployee> getAllEmployeeList() {
        return eService.getEmployeeList();
    }

    @GetMapping("/api/v1/employees/:cd")
    public List<MstEmployee> getEmployeeByCd() {
        return eService.getEmployeeList();
    }

    @GetMapping("/api/v1/employees/name/{name}")
    public List<MstEmployee> getEmployeeByLikeName(@PathVariable("name") String name) {
        return eService.getLikeEmployeeList(name);
    }
}
