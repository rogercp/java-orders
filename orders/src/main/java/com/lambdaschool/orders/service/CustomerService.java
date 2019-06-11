package com.lambdaschool.orders.service;

import com.lambdaschool.orders.model.Customers;

import java.util.ArrayList;

public interface CustomerService
{
    ArrayList<Customers> findAll();

    Customers findCustomerByName(String name);

    Customers save(Customers customer);

    Customers update(Customers customer, long custcode);

    void delete(long custcode);

}
