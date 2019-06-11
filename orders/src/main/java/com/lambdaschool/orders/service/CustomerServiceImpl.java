package com.lambdaschool.orders.service;



import com.lambdaschool.orders.model.Customers;
import com.lambdaschool.orders.repos.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
    private CustomersRepository custrepos;

    @Override
    public ArrayList<Customers> findAll()
    {
       ArrayList<Customers> list = new ArrayList<>();
       custrepos.findAll().iterator().forEachRemaining(list::add);
       return list;
    }

    @Override
    public Customers findCustomerByName(String name)
    {
        return null;
    }

    @Override
    public Customers save(Customers customer)
    {
        return null;
    }

    @Override
    public Customers update(Customers customer, long custcode)
    {
        return null;
    }

    @Override
    public void delete(long custcode)
    {

    }
}
