package com.example.backend.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.backend.constants.EstimateStatus;
import com.example.backend.domain.model.Estimates;
import com.example.backend.domain.model.ViewEstimates;
import com.example.backend.domain.repository.EstimatesRepository;
import com.example.backend.domain.repository.MstCustomersRepository;
import com.example.backend.domain.repository.MstEmployeesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Estimate（見積）のサービス
 */
@Transactional
@Service
public class EstimatesService {

    @Autowired
    private EstimatesRepository eRepo;
    @Autowired
    private MstCustomersRepository mCRepo;
    @Autowired
    private MstEmployeesRepository mERepo;

    //全画面表示用見積リストの取得
    public List<ViewEstimates> getAllViewEstimateList() {
        List<Estimates> eList = eRepo.findAll();
        List<ViewEstimates> eVList = new ArrayList<>();
        convertEstimateListToViewEstimateList(eList, eVList);
        return eVList;
    }

    //指定したIDの画面表示用見積データの取得
    public ViewEstimates getViewEstimateById(int id) {
        Optional<Estimates> eOptional = eRepo.findById(id);
        List<Estimates> eList = new ArrayList<>();
        List<ViewEstimates> eVList = new ArrayList<>();
        eOptional.ifPresent(eList::add);
        convertEstimateListToViewEstimateList(eList, eVList);
        return eVList.get(0);
    }

    //指定したIDと部分一致する画面表示用見積リストの取得
    public List<ViewEstimates> getViewEstimateListById(int id) {
        List<Estimates> eList = eRepo.findByIdLike(id);
        List<ViewEstimates> eVList = new ArrayList<>();
        convertEstimateListToViewEstimateList(eList, eVList);
        return eVList;
    }

    //指定した見積案件名と部分一致する画面表示用見積リストの取得
    public List<ViewEstimates> getViewEstimateListByNameContaining(String name) {
        List<Estimates> eList = eRepo.findByNameContaining(name);
        List<ViewEstimates> eVList = new ArrayList<>();
        convertEstimateListToViewEstimateList(eList, eVList);
        return eVList;
    }

    //指定したステータスと部分一致する画面表示用見積リストの取得
    public List<ViewEstimates> getViewEstimateListByStatusContaining(String status) {
        List<Estimates> eList = eRepo.findByStatusContaining(status);
        List<ViewEstimates> eVList = new ArrayList<>();
        convertEstimateListToViewEstimateList(eList, eVList);
        return eVList;
    }

    //指定した顧客CDが紐づく画面表示用見積リストの取得
    public List<ViewEstimates> getViewEstimateListByCustomerCd(int customerCd) {
        List<Estimates> eList = eRepo.findByCustomerCd(customerCd);
        List<ViewEstimates> eVList = new ArrayList<>();
        convertEstimateListToViewEstimateList(eList, eVList);
        return eVList;
    }

    //指定した担当者CDが紐づく画面表示用見積リストの取得
    public List<ViewEstimates> getViewEstimateListByEmployeeCd(int employeeCd) {
        List<Estimates> eList = eRepo.findByEmployeeCd(employeeCd);
        List<ViewEstimates> eVList = new ArrayList<>();
        convertEstimateListToViewEstimateList(eList, eVList);
        return eVList;
    }

    /**
     * 見積を登録
     * @return 登録した見積の見積ID
     */
    public int insertAndIdReturn(
        String name,
        int amount,
        int budgetedAmount,
        int customerCd,
        int employeeCd,
        String status) {
            String statusCode = getStatusCode(status);
            Estimates initEstimate = eRepo.saveAndFlush(Estimates.builder()
                .name(name)
                .amount(amount)
                .budgetedAmount(budgetedAmount)
                .customerCd(customerCd)
                .employeeCd(employeeCd)
                .status(statusCode)
                .build());
            return initEstimate.getId();
    }

    //見積の更新
    public void update(
        int id,
        String name,
        int amount,
        int budgetedAmount,
        int customerCd,
        int employeeCd,
        String status) {
            String statusCode = getStatusCode(status);
            eRepo.saveAndFlush(Estimates.builder()
            .id(id)
            .name(name)
            .amount(amount)
            .budgetedAmount(budgetedAmount)
            .customerCd(customerCd)
            .employeeCd(employeeCd)
            .status(statusCode)
            .build());
    }

    //指定したIDの見積を削除
    public void deleteById(int id) {
        eRepo.deleteById(id);
    }

    //ステータス名からステータスコードを切り取り
    private String getStatusCode(String status) {
        return String.valueOf(status.charAt(0));
    }

    //与えられた見積リストを画面表示用に変換
    private void convertEstimateListToViewEstimateList(
        List<Estimates> eList,
        List<ViewEstimates> eVList) {
            for (Estimates e : eList) {
                String customerName = getCustomerName(e);
                String employeeName = getEmployeeName(e);
                String status = EstimateStatus.findByIndex(Integer.parseInt(e.getStatus())).getlabel();
                eVList.add(new ViewEstimates(
                    e.getId(),
                    e.getName(),
                    status,
                    e.getCustomerCd(),
                    customerName,
                    e.getEmployeeCd(),
                    employeeName,
                    e.getAmount(),
                    e.getBudgetedAmount()
                ));
            }
    }

    //担当者CDから担当者名を取得
    private String getEmployeeName(Estimates e) {
        return mERepo.getById(e.getEmployeeCd()).getName();
    }

    //顧客CDから顧客名を取得
    private String getCustomerName(Estimates e) {
        return mCRepo.getById(e.getCustomerCd()).getName();
    }
}
