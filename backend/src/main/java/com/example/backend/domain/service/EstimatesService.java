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

@Transactional
@Service
public class EstimatesService {

    @Autowired
    private EstimatesRepository eRepo;
    @Autowired
    private MstCustomersRepository mCRepo;
    @Autowired
    private MstEmployeesRepository mERepo;

    public List<ViewEstimates> getAllViewEstimateList() {
        List<Estimates> eList = eRepo.findAll();
        List<ViewEstimates> eVList = new ArrayList<>();
        convertEstimateListToViewEstimateList(eList, eVList);
        return eVList;
    }

    public ViewEstimates getViewEstimateById(int id) {
        Optional<Estimates> eOptional = eRepo.findById(id);
        List<Estimates> eList = new ArrayList<>();
        List<ViewEstimates> eVList = new ArrayList<>();
        eOptional.ifPresent(eList::add);
        convertEstimateListToViewEstimateList(eList, eVList);
        return eVList.get(0);
    }

    public List<ViewEstimates> getViewEstimateListByLikeId(int id) {
        List<Estimates> eList = eRepo.findByIdLike(id);
        List<ViewEstimates> eVList = new ArrayList<>();
        convertEstimateListToViewEstimateList(eList, eVList);
        return eVList;
    }

    public List<ViewEstimates> getViewEstimateListByContainingName(String name) {
        List<Estimates> eList = eRepo.findByNameContaining(name);
        List<ViewEstimates> eVList = new ArrayList<>();
        convertEstimateListToViewEstimateList(eList, eVList);
        return eVList;
    }

    public List<ViewEstimates> getViewEstimateListByLikeStatus(String status) {
        List<Estimates> eList = eRepo.findByStatusLike(status);
        List<ViewEstimates> eVList = new ArrayList<>();
        convertEstimateListToViewEstimateList(eList, eVList);
        return eVList;
    }

    public List<ViewEstimates> getViewEstimateListByLikeCustomerCd(String customerName) {
        int customerCd = mCRepo.findByName(customerName).getCd();
        List<Estimates> eList = eRepo.findByCustomerCdLike(customerCd);
        List<ViewEstimates> eVList = new ArrayList<>();
        convertEstimateListToViewEstimateList(eList, eVList);
        return eVList;
    }

    public List<ViewEstimates> getViewEstimateListByLikeEmployeeCd(String employeeName) {
        int employeeCd = mERepo.findByName(employeeName).getCd();
        List<Estimates> eList = eRepo.findByEmployeeCdLike(employeeCd);
        List<ViewEstimates> eVList = new ArrayList<>();
        convertEstimateListToViewEstimateList(eList, eVList);
        return eVList;
    }

    public void insert(String name, int amount, int budgetedAmount, int customerCd, int employeeCd, String status) {
        eRepo.save(Estimates.builder()
            .name(name)
            .amount(amount)
            .budgetedAmount(budgetedAmount)
            .customerCd(customerCd)
            .employeeCd(employeeCd)
            .status(status)
            .build());
    }

    public void update(int id, String name, int amount, int budgetedAmount, int customerCd, int employeeCd, String status) {
        eRepo.save(Estimates.builder()
        .id(id)
        .name(name)
        .amount(amount)
        .budgetedAmount(budgetedAmount)
        .customerCd(customerCd)
        .employeeCd(employeeCd)
        .status(status)
        .build());
    }

    public void deleteById(int id) {
        eRepo.deleteById(id);
    }

    private void convertEstimateListToViewEstimateList(List<Estimates> eList, List<ViewEstimates> eVList) {
        for (Estimates e : eList) {
            String customerName = getCustomerName(e);
            String employeeName = getEmployeeName(e);
            String status = EstimateStatus.findByIndex(Integer.parseInt(e.getStatus())).getlabel();
            eVList.add(new ViewEstimates(
                e.getId(),
                e.getName(),
                status,
                customerName,
                employeeName,
                e.getAmount(),
                e.getBudgetedAmount()
            ));
        }
    }

    private String getEmployeeName(Estimates e) {
        return mERepo.getById(e.getEmployeeCd()).getName();
    }

    private String getCustomerName(Estimates e) {
        return mCRepo.getById(e.getCustomerCd()).getName();
    }
}
