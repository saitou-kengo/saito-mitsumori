package com.example.backend.controller;

import java.util.List;

import com.example.backend.domain.model.MstEmployees;
import com.example.backend.domain.service.MstEmployeesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/employees/:cd")
    public List<MstEmployees> getEmployeeByCd() {
        return eService.getEmployeeList();
    }

    @GetMapping(value = "/employees/name/:name", params = "name")
    public List<MstEmployees> getEmployeeByLikeName(@RequestParam String name) {
        return eService.getLikeEmployeeList(name);
    }
}
