package com.example.backend.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.backend.domain.model.Estimate;
import com.example.backend.domain.model.MstCustomer;
import com.example.backend.domain.model.MstEmployee;
import com.example.backend.domain.model.ViewEstimate;
import com.example.backend.domain.service.CustomerService;
import com.example.backend.domain.service.EmployeeService;
import com.example.backend.domain.service.EstimateService;

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
    CustomerService cService;
    EmployeeService emService;

    @GetMapping("/api/v1/estimates")
    public List<ViewEstimate> getAllEstimateList() {
        List<Estimate> eList = esService.getEstimateList();
        return createViewEstimateList(eList);
    }

    @PostMapping("/api/v1/estimates")
    public void insertEstimate() {

    }

    @PutMapping("/api/v1/estimates/:id")
    public void updateEstimate() {

    }

    @DeleteMapping("/api/v1/estimates/{id}")
    public void deleteEstimateById(@PathVariable("id") int id) {
        esService.delete(id);
    }

    private List<ViewEstimate> createViewEstimateList(List<Estimate> eList) {
        List<ViewEstimate> vEList = new ArrayList<>();
        for (Estimate e : eList) {
            MstCustomer customer = cService.getCustomer(e.getId());
            MstEmployee employee = emService.getEmployee(e.getId());
            vEList.add(new ViewEstimate(
                e.getId(),
                e.getEstimateName(),
                e.getStatus(),
                customer.getName(),
                employee.getName(),
                e.getBudgetedAmount(),
                e.getEstimateAmount()
            ));
        }
        return vEList;
    }
}
