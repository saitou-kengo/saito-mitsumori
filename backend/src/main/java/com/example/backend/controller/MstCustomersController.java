package com.example.backend.controller;

import java.util.List;

import com.example.backend.domain.model.MstCustomers;
import com.example.backend.domain.service.MstCustomersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    // @GetMapping("/api/v1/customers/:cd")
    // public List<MstCustomers> getCustomerByCd() {
    //     return mstCustomersService;
    // }

    @GetMapping(value = "/customers/name/:name", params = "name")
    public List<MstCustomers> getCustomerByLikeName(@RequestParam String name) {
        return mstCustomersService.getLikeCustomerList(name);
    }
}
