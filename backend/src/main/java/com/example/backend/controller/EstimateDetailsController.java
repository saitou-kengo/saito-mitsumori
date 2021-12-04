package com.example.backend.controller;

import java.util.List;

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

/**
 * EstimateDetails（見積明細）のコントローラー
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"http://localhost:8081"})
public class EstimateDetailsController {

    @Autowired
    private EstimateDetailsService dService;

    //全見積明細リストの取得
    @GetMapping("/estimate-details")
    public List<ViewEstimateDetails> getAllDetailList() {
        return dService.getAllDetailList();
    }

    //指定したIDの全見積明細リストの取得
    @GetMapping(value="/estimate-details/:id", params = "id")
    public List<ViewEstimateDetails> getAllDetailListById(@RequestParam int id) {
        return dService.getAllDetailListByEstimateId(id);
    }

    //見積明細の登録
    @PostMapping("/estimate-details")
    public void insertDetails(
        @RequestParam("estimateId") int estimateId,
        @RequestParam("subId") int subId,
        @RequestParam("productCd") int productCd,
        @RequestParam("quantity") int quantity) {
            dService.insert(estimateId, subId, productCd, quantity);
    }

    //見積明細の更新
    @PutMapping("/estimate-details/:id")
    public void updateDetail(@RequestParam int id,
        @RequestParam int estimateId,
        @RequestParam int productCd,
        @RequestParam int quantity) {
            dService.update(id, estimateId, productCd, quantity);
    }

    //指定したIDの見積明細の削除
    @DeleteMapping("/estimate-details/:id")
    public void deleteDetailById(@RequestParam int id) {
        dService.deleteById(id);
    }

}
