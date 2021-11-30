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


@Transactional
@Service
public class EstimateDetailsService {
    
    @Autowired
    private EstimateDetailsRepository eDRepo;
    @Autowired
    private MstProductsRepository mPRepo;

    public List<ViewEstimateDetails> getAllDetailList() {
        List<EstimateDetails> eDList = eDRepo.findAll();
        List<ViewEstimateDetails> vEDList = new ArrayList<>();
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
        return vEDList;
    }

    public List<ViewEstimateDetails> getAllDetailListByEstimateId(int id) {
        List<EstimateDetails> eDList = eDRepo.findByEstimateId(id);
        List<ViewEstimateDetails> vEDList = new ArrayList<>();
        for (EstimateDetails eD : eDList) {
            String productName = mPRepo.findById(eD.getProductCd()).orElseThrow().getName();
            int price = mPRepo.findById(eD.getProductCd()).orElseThrow().getPrice();
            vEDList.add(new ViewEstimateDetails(
                eD.getId(),
                eD.getSubId(),
                productName,
                price,
                eD.getQuantity()));
        }
        return vEDList;
    }

    public void insert(int estimateId, int productCd, int quantity) {
        eDRepo.save(EstimateDetails.builder()
        .estimateId(estimateId)
        .productCd(productCd)
        .quantity(quantity)
        .build());
    }

    public void update(int id, int estimateId, int productCd, int quantity) {
        eDRepo.save(EstimateDetails.builder()
        .id(id)
        .estimateId(estimateId)
        .productCd(productCd)
        .quantity(quantity)
        .build());
    }

    public void deleteById(int id) {
        eDRepo.deleteById(id);
    }
}
