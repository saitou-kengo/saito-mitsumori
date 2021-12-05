package com.example.backend.controller;

import java.util.List;

import com.example.backend.domain.model.ViewEstimates;
import com.example.backend.domain.service.EstimateDetailsService;
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

/**
 * Estimates（見積）のコントローラー
 */
@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"http://localhost:8081"})
public class EstimatesController {

    @Autowired
    private EstimatesService eService;
    @Autowired
    private EstimateDetailsService eDService;

    //全見積リストの取得
    @GetMapping("/estimates")
    public List<ViewEstimates> getAllEstimateList() {
        return eService.getAllViewEstimateList();
    }

    //指定したIDの見積データの取得
    @GetMapping(value = "/estimates/:id", params = "id")
    public ViewEstimates getViewEstimateById(@RequestParam int id) {
        return eService.getViewEstimateById(id);
    }

    //指定したIDに部分一致する全見積リストの取得
    @GetMapping("/estimates/like-id/:id")
    public List<ViewEstimates> getViewEstimateListByLikeId(@RequestParam int id) {
        return eService.getViewEstimateListById(id);
    }

    //指定した見積名に部分一致する全見積リストの取得
    @GetMapping("/estimates/like-name/:name")
    public List<ViewEstimates> getViewEstimateListByLikeEstimateName(@RequestParam String name) {
        return eService.getViewEstimateListByNameContaining(name);
    }

    //指定したステータスに部分一致する全見積リストの取得
    @GetMapping("/estimates/like-status/:status")
    public List<ViewEstimates> getEstimateByLikeStatus(@RequestParam String status) {
        return eService.getViewEstimateListByStatusContaining(status);
    }

    //指定した顧客IDの全見積リストの取得
    @GetMapping("/estimates/customer-cd/:cd")
    public List<ViewEstimates> getEstimateByCustomerCd(@RequestParam int customerCd) {
        return eService.getViewEstimateListByCustomerCd(customerCd);
    }

    //指定した担当者IDの全見積リストの取得
    @GetMapping("/estimates/employee-cd/:cd")
    public List<ViewEstimates> getEstimateByEmployeeCd(@RequestParam int employeeCd) {
        return eService.getViewEstimateListByEmployeeCd(employeeCd);
    }

    /**
     * 見積の登録
     * @return 登録した見積の見積ID
     */
    @PostMapping("/estimates")
    public int insertAndIdReturn(
        @RequestParam("name") String name,
        @RequestParam("amount") int amount,
        @RequestParam("budgetedAmount") int budgetedAmount,
        @RequestParam("customerCd") int customerCd,
        @RequestParam("employeeCd") int employeeCd,
        @RequestParam("status") String status) {
            return eService.insertAndIdReturn(
                name,
                amount,
                budgetedAmount,
                customerCd,
                employeeCd,
                status);
    }

    //見積の更新
    @PutMapping("/estimates/:id")
    public void updateEstimate(
        @RequestParam("id") int id,
        @RequestParam("name") String name,
        @RequestParam("amount") int amount,
        @RequestParam("budgetedAmount") int budgetedAmount,
        @RequestParam("customerCd") int customerCd,
        @RequestParam("employeeCd") int employeeCd,
        @RequestParam("status") String status) {
            eService.update(
            id,
            name,
            amount,
            budgetedAmount,
            customerCd,
            employeeCd,
            status);
    }

    //指定したIDの見積及び見積に紐づく明細を削除
    @DeleteMapping("/estimates/:id")
    public void deleteEstimateById(@RequestParam int id) {
        eDService.deleteByEstimateId(id);
        eService.deleteById(id);
    }

}
