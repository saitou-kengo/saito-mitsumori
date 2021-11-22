package com.example.backend.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.backend.domain.model.JoinEstimateToMst;
import com.example.backend.domain.service.EstimateService;
import com.example.backend.domain.service.JoinEstimateToMstService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:8081/estimates")
public class EstimateController {

    @Autowired
    EstimateService esService;
    JoinEstimateToMstService jEService;

    @GetMapping("/api/v1/estimates")
    public List<JoinEstimateToMst> getAllEstimateList() {
        return jEService.getAllJoinEstimateToMstList();
    }

    @GetMapping("/api/v1/estimates/{id}")
    public List<JoinEstimateToMst> getEstimateById(@PathVariable("id") int id) {
        List<JoinEstimateToMst> eList = new ArrayList<>();
        eList.add(jEService.getEstimate(id));
        return eList;
    }

    @GetMapping("/api/v1/estimates/like-name/{name}")
    public List<JoinEstimateToMst> getEstimateByLikeEstimateName(@PathVariable("name") String name) {
        return jEService.getLikeEstimateNameList(name);
    }

    @GetMapping("/api/v1/estimates/like-name/{customer-name}")
    public List<JoinEstimateToMst> getEstimateByLikeCustomerName(@PathVariable("customer-name") String name) {
        return jEService.getLikeCustomerNameList(name);
    }

    @GetMapping("/api/v1/estimates/like-name/{employee-name}")
    public List<JoinEstimateToMst> getEstimateByLikeEmployeeName(@PathVariable("employee-name") String name) {
        return jEService.getLikeEmployeeNameList(name);
    }

    @GetMapping("/api/v1/estimates/like-name/{status}")
    public List<JoinEstimateToMst> getEstimateByLikeStatus(@PathVariable("status") String status) {
        return jEService.getLikeStatusList(status);
    }

    @PostMapping("/api/v1/estimates")
    public void insertEstimate() {

    }

    @PutMapping("/api/v1/estimates/{id}")
    public void updateEstimate() {

    }

    @DeleteMapping("/api/v1/estimates/{id}")
    public void deleteEstimateById(@PathVariable("id") int id) {
        esService.delete(id);
    }

}
