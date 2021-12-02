package com.example.backend.controller;

import java.util.List;

import com.example.backend.domain.model.EstimateDetails;
import com.example.backend.domain.model.ViewEstimateDetails;
import com.example.backend.domain.service.EstimateDetailsService;

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
public class EstimateDetailsController {

    @Autowired
    private EstimateDetailsService dService;

    @GetMapping("/estimate-details")
    public List<ViewEstimateDetails> getAllDetailList() {
        return dService.getAllDetailList();
    }

    @GetMapping(value="/estimate-details/:id", params = "id")
    public List<ViewEstimateDetails> getAllDetailListById(@RequestParam int id) {
        return dService.getAllDetailListByEstimateId(id);
    }

    @PostMapping("/estimate-details")
    public void insertDetails(@RequestParam List<EstimateDetails> details) {
        for (EstimateDetails e : details) {
            System.out.println(e);
            // dService.insert(e.getEstimateId(), e.getProductCd(), e.getQuantity());
        }
    }

    @PutMapping("/estimate-details/:id")
    public void updateDetail(@RequestParam int id,
        @RequestParam int estimateId,
        @RequestParam int productCd,
        @RequestParam int quantity) {
        dService.update(id, estimateId, productCd, quantity);
    }

    @DeleteMapping("/estimate-details/:id")
    public void deleteDetailById(@RequestParam int id) {
        dService.deleteById(id);
    }
}
