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

/**
 * MstEmployee（担当者）のコントローラー
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"http://localhost:8081"})
public class MstEmployeesController {

    @Autowired
    private MstEmployeesService eService;

    //全担当者リストの取得
    @GetMapping("/employees")
    public List<MstEmployees> getAllEmployeeList() {
        return eService.getEmployeeList();
    }

    //指定した担当者CDの担当者の取得
    @GetMapping(value = "/employees/:cd", params = "cd")
    public MstEmployees getEmployeeByCd(@RequestParam int cd) {
        return eService.getEmployee(cd);
    }

    //指定した名前に部分一致する全担当者リストの取得
    @GetMapping("/employees/name/:cd")
    public List<MstEmployees> getEmployeeByLikeName(@RequestParam String name) {
        return eService.getEmployeeListByNameContaining(name);
    }
}
