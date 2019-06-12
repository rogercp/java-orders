package com.lambdaschool.orders.controller;


import com.lambdaschool.orders.model.Customers;
import com.lambdaschool.orders.service.CustomerService;
import com.lambdaschool.orders.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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


    @GetMapping(value="/customer/name/{custname}",
            produces={"application/json"})
    public ResponseEntity<?> getCustomerByName(
            @PathVariable String custname
    )
    {
       Customers c=customerService.findCustomerByName(custname);
       return new ResponseEntity<>(c,HttpStatus.OK);
    }

    @DeleteMapping(value = "/data/customer/update/{custcode}")
    public ResponseEntity<?> deleteByCustCode(
            @PathVariable
                    long custcode)
    {
        customerService.delete(custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
