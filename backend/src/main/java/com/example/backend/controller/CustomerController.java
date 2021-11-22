package com.example.backend.controller;

import java.util.List;

import com.example.backend.domain.model.MstCustomer;
import com.example.backend.domain.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    
    @Autowired
    CustomerService cService;

    @GetMapping("/api/v1/customers")
    public List<MstCustomer> getAllCustomerList() {
        return cService.getCustomerList();
    }

    @GetMapping("/api/v1/customers/:cd")
    public List<MstCustomer> getCustomerByCd() {
        return cService.getCustomerList();
    }

    @GetMapping("/api/v1/customers/name/{name}")
    public List<MstCustomer> getCustomerByLikeName(@PathVariable("name") String name) {
        return cService.getLikeCustomerList(name);
    }
}
