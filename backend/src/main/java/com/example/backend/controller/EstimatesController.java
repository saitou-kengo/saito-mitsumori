package com.example.backend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.backend.domain.model.Estimates;
import com.example.backend.domain.model.ViewEstimates;
import com.example.backend.domain.service.EstimatesService;
import com.example.backend.domain.service.MstCustomersService;
import com.example.backend.domain.service.MstEmployeesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"http://localhost:8081"})
public class EstimatesController {

    @Autowired
    private EstimatesService eService;

    @GetMapping("/estimates")
    public List<ViewEstimates> getAllEstimateList() {
        return eService.getViewEstimateList();
    }

    // @GetMapping(value = "/estimates/:id", params = "id")
    // public List<JoinEstimateToMst> getEstimateById(@RequestParam int id) {
    //     return 
    // }

    // @GetMapping("/api/v1/estimates/like-name/{name}")
    // public List<JoinEstimateToMst> getEstimateByLikeEstimateName(@PathVariable("name") String name) {
    //     return jEService.getLikeEstimateNameList(name);
    // }

    // @GetMapping("/api/v1/estimates/like-name/{customer-name}")
    // public List<JoinEstimateToMst> getEstimateByLikeCustomerName(@PathVariable("customer-name") String name) {
    //     return jEService.getLikeCustomerNameList(name);
    // }

    // @GetMapping("/api/v1/estimates/like-name/{employee-name}")
    // public List<JoinEstimateToMst> getEstimateByLikeEmployeeName(@PathVariable("employee-name") String name) {
    //     return jEService.getLikeEmployeeNameList(name);
    // }

    // @GetMapping("/api/v1/estimates/like-name/{status}")
    // public List<JoinEstimateToMst> getEstimateByLikeStatus(@PathVariable("status") String status) {
    //     return jEService.getLikeStatusList(status);
    // }

    @PostMapping(value = "/estimates")
    public void insertEstimate(@RequestParam Estimates estimate) {
        eService.insert(estimate);
    }

    @PutMapping(value = "/estimates/:id")
    public void updateEstimate(@RequestParam Estimates estimate) {
        eService.update(estimate);
    }

    @DeleteMapping(value = "/estimates/:id")
    public void deleteEstimateById(@RequestParam int id) {
        eService.deleteById(id);
    }

}
