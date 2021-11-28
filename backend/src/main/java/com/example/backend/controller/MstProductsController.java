package com.example.backend.controller;

import java.util.List;

import com.example.backend.domain.model.MstProducts;
import com.example.backend.domain.service.MstProductsService;

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
public class MstProductsController {

    @Autowired
    private MstProductsService pService;

    @GetMapping("/products")
    public List<MstProducts> getAllProductList() {
        return pService.getProductList();
    }

    @GetMapping("/products/:cd")
    public List<MstProducts> getProductByCd() {
        return pService.getProductList();
    }

    @GetMapping(value = "/products/:name", params = "name")
    public List<MstProducts> getProductByLikeName(@RequestParam String name) {
        return pService.getLikeProductList(name);
    }
}
