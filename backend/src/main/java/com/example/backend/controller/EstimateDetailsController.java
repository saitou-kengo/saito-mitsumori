package com.example.backend.controller;

import java.util.List;
import java.util.Map;

import com.example.backend.domain.model.EstimateDetails;
import com.example.backend.domain.model.ViewEstimateDetails;
import com.example.backend.domain.service.EstimateDetailsService;

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
public class EstimateDetailsController {

    @Autowired
    private EstimateDetailsService dService;

    @GetMapping("/estimate-details")
    public List<ViewEstimateDetails> getAllDetailList() {
        return dService.getAllDetailList();
    }

    @GetMapping(value="/estimate-details/:id", params = "id")
    public List<ViewEstimateDetails> getAllDetailListById(@RequestParam int id) {
        return dService.getAllDetailListById(id);
    }

    @PostMapping("/estimate-details")
    public void insertEstimate(@RequestParam EstimateDetails detail) {
        dService.insert(detail);
    }

    @PutMapping("/estimate-details/{id}")
    public void updateEstimate(@RequestParam EstimateDetails detail) {
        dService.update(detail);
    }

    @DeleteMapping("/estimate-details/:id")
    public void deleteEstimateById(@RequestParam int id) {
        dService.deleteById(id);
    }
}
