package com.example.backend.domain.service;

import java.util.ArrayList;
import java.util.List;

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

    public List<ViewEstimates> getViewEstimateList() {
        List<Estimates> eList = eRepo.findAll();
        List<ViewEstimates> eVList = new ArrayList<>();
        for (Estimates e : eList) {
            String customerName = mCRepo.getById(e.getCustomerCd()).getName();
            String employeeName = mERepo.getById(e.getEmployeeCd()).getName();
            eVList.add(new ViewEstimates(
                e.getId(),
                e.getName(),
                e.getStatus(),
                customerName,
                employeeName,
                e.getAmount(),
                e.getBudgetedAmount()
            ));
        }
        return eVList;
    }

    public void insert(Estimates estimates) {
        eRepo.save(estimates);
    }

    public void update(Estimates estimates) {
        eRepo.save(estimates);
    }

    public void deleteById(int id) {
        eRepo.deleteById(id);
    }
}
