package com.lambdaschool.orders.service;



import com.lambdaschool.orders.model.Customers;
import com.lambdaschool.orders.repos.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
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
    public Customers findCustomerByName(String custname)
    {
        Customers customer = custrepos.findByName(custname);

        if(customer==null)
        {
            throw new EntityNotFoundException("Customer "+custname+" not found");
        }
        return customer;
    }


    @Override
    public void delete(long custcode)
    {
        if (custrepos.findById(custcode).isPresent())
        {
            custrepos.deleteById(custcode);
        }
        else
        {
            throw new EntityNotFoundException(Long.toString(custcode));
        }
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




}
