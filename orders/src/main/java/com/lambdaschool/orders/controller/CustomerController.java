package com.lambdaschool.orders.controller;


import com.lambdaschool.orders.model.Customers;
import com.lambdaschool.orders.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/stuff")
public class CustomerController
{
    @Autowired
    private CustomerService customerService;

    @GetMapping(value="/customer/order",
                produces={"application/json"})
    public ResponseEntity<?> listAllCustomersWithOrders()
    {
        ArrayList<Customers> myList= customerService.findAll();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

}
