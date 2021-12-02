package com.example.backend.controller;

import java.util.List;

import com.example.backend.domain.model.Estimates;
import com.example.backend.domain.model.ViewEstimates;
import com.example.backend.domain.service.EstimatesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
        return eService.getAllViewEstimateList();
    }

    @GetMapping(value = "/estimates/:id", params = "id")
    public ViewEstimates getViewEstimateById(@RequestParam int id) {
        return eService.getViewEstimateById(id);
    }

    @GetMapping("/estimates/like-id/:id")
    public List<ViewEstimates> getViewEstimateListByLikeId(@RequestParam int id) {
        return eService.getViewEstimateListByLikeId(id);
    }

    @GetMapping("/estimates/like-name/:name")
    public List<ViewEstimates> getViewEstimateListByLikeEstimateName(@RequestParam String name) {
        return eService.getViewEstimateListByContainingName(name);
    }

    @GetMapping("/estimates/like-status/:status")
    public List<ViewEstimates> getEstimateByLikeStatus(@RequestParam String status) {
        return eService.getViewEstimateListByLikeStatus(status);
    }

    @GetMapping("/estimates/customer-cd/:cd")
    public List<ViewEstimates> getEstimateByLikeCustomerCd(@RequestParam String customerName) {
        return eService.getViewEstimateListByLikeCustomerCd(customerName);
    }

    @GetMapping("/estimates/employee-cd/:cd")
    public List<ViewEstimates> getEstimateByLikeEmployeeCd(@RequestParam String employeeName) {
        return eService.getViewEstimateListByLikeEmployeeCd(employeeName);
    }

    @PostMapping("/estimates")
    public void insertEstimate(
            @RequestParam(name="name", required = false) String name,
            @RequestParam(name="amount", required = false) int amount,
            @RequestParam(name="budgetedAmount", required = false) int budgetedAmount,
            @RequestParam(name="customerCd", required = false) int customerCd,
            @RequestParam(name="employeeCd", required = false) int employeeCd,
            @RequestParam(name="status", required = false) String status) {
                System.out.println(name + "：");
                System.out.println(amount + "：");
                System.out.println(budgetedAmount + "：");
                System.out.println(customerCd + "：");
                System.out.println(employeeCd + "：");
                System.out.println(status + "：");
        // eService.insert(
        //     name,
        //     amount,
        //     budgetedAmount,
        //     customerCd,
        //     employeeCd,
        //     status);
    }

    @PutMapping("/estimates/:id")
    public void updateEstimate(
        @RequestParam int id,
        @RequestParam String name,
        @RequestParam int amount,
        @RequestParam int budgetedAmount,
        @RequestParam int customerCd,
        @RequestParam int employeeCd,
        @RequestParam String status) {
            System.out.println(id);
            System.out.println(name);
        eService.update(
        id,
        name,
        amount,
        budgetedAmount,
        customerCd,
        employeeCd,
        status);
    }

    @DeleteMapping("/estimates/:id")
    public void deleteEstimateById(@RequestParam int id) {
        eService.deleteById(id);
    }

}
