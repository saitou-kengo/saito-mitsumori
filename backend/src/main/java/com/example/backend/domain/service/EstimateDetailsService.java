package com.example.backend.domain.service;

import java.util.ArrayList;
import java.util.List;

import com.example.backend.domain.model.EstimateDetails;
import com.example.backend.domain.model.ViewEstimateDetails;
import com.example.backend.domain.repository.EstimateDetailsRepository;
import com.example.backend.domain.repository.MstProductsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * EstimateDetail（見積明細）のサービス
 */
@Transactional
@Service
public class EstimateDetailsService {
    
    @Autowired
    private EstimateDetailsRepository eDRepo;
    @Autowired
    private MstProductsRepository mPRepo;

    //全画面表示用見積明細リストを取得
    public List<ViewEstimateDetails> getAllDetailList() {
        List<EstimateDetails> eDList = eDRepo.findAll();
        List<ViewEstimateDetails> vEDList = new ArrayList<>();
            convertEstimateDetailsListToViewEstimateDetailsList(eDList, vEDList);
            return vEDList;
    }

    //指定した見積IDの全画面表示用見積明細リストを取得
    public List<ViewEstimateDetails> getAllDetailListByEstimateId(int id) {
        List<EstimateDetails> eDList = eDRepo.findByEstimateId(id);
        List<ViewEstimateDetails> vEDList = new ArrayList<>();
            convertEstimateDetailsListToViewEstimateDetailsList(eDList, vEDList);
            return vEDList;
    }

    //見積明細の登録
    public void insert(int estimateId, int subId, int productCd, int quantity) {
        eDRepo.save(EstimateDetails.builder()
        .subId(subId)
        .estimateId(estimateId)
        .productCd(productCd)
        .quantity(quantity)
        .build());
    }

    //見積明細の更新
    public void update(int subId, int estimateId, int productCd, int quantity) {
        eDRepo.save(EstimateDetails.builder()
        .id(subId)
        .estimateId(estimateId)
        .productCd(productCd)
        .quantity(quantity)
        .build());
    }

    //指定したIDの見積明細の削除
    public void deleteById(int id) {
        eDRepo.deleteById(id);
    }

    //指定した見積IDに紐づく見積明細の削除
    public void deleteByEstimateId(int estimateId) {
        eDRepo.deleteByEstimateId(estimateId);
    }

    //与えられた見積明細リストを画面表示用に変換
    private void convertEstimateDetailsListToViewEstimateDetailsList(
        List<EstimateDetails> eDList,
        List<ViewEstimateDetails> vEDList) {
            for (EstimateDetails eD : eDList) {
                String productName = mPRepo.getById(eD.getProductCd()).getName();
                int price = mPRepo.getById(eD.getProductCd()).getPrice();
                vEDList.add(new ViewEstimateDetails(
                    eD.getId(),
                    eD.getSubId(),
                    productName,
                    price,
                    eD.getQuantity()));
            }
    }

}
