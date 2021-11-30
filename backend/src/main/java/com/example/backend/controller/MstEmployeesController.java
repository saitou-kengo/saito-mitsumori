package com.example.backend.controller;

import java.util.List;

import com.example.backend.domain.model.MstEmployees;
import com.example.backend.domain.service.MstEmployeesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"http://localhost:8081"})
public class MstEmployeesController {
    @Autowired
    private MstEmployeesService eService;

    @GetMapping("/employees")
    public List<MstEmployees> getAllEmployeeList() {
        return eService.getEmployeeList();
    }

    @GetMapping(value = "/employees/:cd", params = "cd")
    public MstEmployees getEmployeeByCd(@RequestParam int cd) {
        return eService.getEmployee(cd);
    }

    @GetMapping("/employees/name/:cd")
    public List<MstEmployees> getEmployeeByLikeName(@RequestParam String name) {
        return eService.getLikeEmployeeList(name);
    }
}
