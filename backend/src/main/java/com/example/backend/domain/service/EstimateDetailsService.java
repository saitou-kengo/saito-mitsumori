package com.example.backend.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                productName,
                price,
                eD.getQuantity()));
        }
        return vEDList;
    }

    public List<ViewEstimateDetails> getAllDetailListById(int id) {
        Optional<EstimateDetails> eOptional = eDRepo.findById(id);
        List<EstimateDetails> eDList = new ArrayList<>();
        List<ViewEstimateDetails> vEDList = new ArrayList<>();
        eOptional.ifPresent(eDList::add);
        for (EstimateDetails eD : eDList) {
            String productName = mPRepo.findById(eD.getProductCd()).orElseThrow().getName();
            int price = mPRepo.findById(eD.getProductCd()).orElseThrow().getPrice();
            vEDList.add(new ViewEstimateDetails(
                eD.getId(),
                productName,
                price,
                eD.getQuantity()));
        }
        return vEDList;
    }

    public void insert(EstimateDetails eDetails) {
        eDRepo.save(eDetails);
    }

    public void update(EstimateDetails eDetails) {
        eDRepo.save(eDetails);
    }

    public void deleteById(int id) {
        eDRepo.deleteById(id);
    }
}
