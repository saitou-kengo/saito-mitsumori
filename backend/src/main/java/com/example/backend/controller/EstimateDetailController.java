package com.example.backend.controller;

import java.util.List;

import com.example.backend.domain.model.JoinDetailToMst;
import com.example.backend.domain.service.DetailService;
import com.example.backend.domain.service.JoinDetailToMstService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8081/estimates/new")
public class EstimateDetailController {

    @Autowired
    DetailService dService;
    JoinDetailToMstService jDService;

    @GetMapping("/api/v1/estimate-details")
    public List<JoinDetailToMst> getAllDetailList() {
        return jDService.getAllJoinDetailToMstList();
    }

    @GetMapping("/api/v1/estimate-details/{id}")
    public List<JoinDetailToMst> getAllDetailListById(@PathVariable("id") int id) {
        return jDService.getAllJoinDetailToMstListByEstimateId(id);
    }

    @PostMapping("/api/v1/estimate-details")
    public void insertEstimate() {

    }

    @PutMapping("/api/v1/estimate-details/{id}")
    public void updateEstimate() {

    }

    @DeleteMapping("/api/v1/estimate-details/{id}")
    public void deleteEstimateById(@PathVariable("id") int id) {
        dService.delete(id);
    }
}
