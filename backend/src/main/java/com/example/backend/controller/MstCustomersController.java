package com.example.backend.controller;

import java.util.List;

import com.example.backend.domain.model.MstCustomers;
import com.example.backend.domain.service.MstCustomersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = {"http://localhost:8081"})
public class MstCustomersController {
    
    @Autowired
    private MstCustomersService mstCustomersService;

    @GetMapping("/customers")
    public List<MstCustomers> getAllCustomerList() {
        return mstCustomersService.getCustomerList();
    }

    @GetMapping(value = "/customers/:cd", params = "cd")
    public MstCustomers getCustomerByCd(@RequestParam int cd) {
        return mstCustomersService.getCustomer(cd);
    }

    @GetMapping("/customers/name/:name")
    public List<MstCustomers> getCustomerByLikeName(@RequestParam String name) {
        return mstCustomersService.getLikeCustomerList(name);
    }
}
