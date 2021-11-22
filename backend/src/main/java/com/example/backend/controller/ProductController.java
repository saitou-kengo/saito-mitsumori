package com.example.backend.controller;

import java.util.List;

import com.example.backend.domain.model.MstProduct;
import com.example.backend.domain.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductService pService;

    @GetMapping("/api/v1/products")
    public List<MstProduct> getAllProductList() {
        return pService.getProductList();
    }

    @GetMapping("/api/v1/products/:cd")
    public List<MstProduct> getProductByCd() {
        return pService.getProductList();
    }

    @GetMapping("/api/v1/products/name/{name}")
    public List<MstProduct> getProductByLikeName(@PathVariable("name") String name) {
        return pService.getLikeProductList(name);
    }
}
