package com.example.backend.controller;

import java.util.List;

import com.example.backend.domain.model.MstProducts;
import com.example.backend.domain.service.MstProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * MstProduct（商品）のコントローラー
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"http://localhost:8081"})
public class MstProductsController {

    @Autowired
    private MstProductsService pService;

    //全商品リストの取得
    @GetMapping("/products")
    public List<MstProducts> getAllProductList() {
        return pService.getProductList();
    }

    //指定した商品CDの商品の取得
    @GetMapping(value = "/products/:cd", params = "cd")
    public MstProducts getProductByCd(@RequestParam int cd) {
        return pService.getProduct(cd);
    }

    //指定した名前に部分一致する全商品リストの取得
    @GetMapping("/products/name/:name")
    public List<MstProducts> getProductByLikeName(@RequestParam String name) {
        return pService.getProductListByNameContaining(name);
    }
}
