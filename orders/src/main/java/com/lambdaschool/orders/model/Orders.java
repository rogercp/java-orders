package com.lambdaschool.orders.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Orders
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderNum;
    private double orderAmt;
    private double advanceAmt;
    private String orderDesc;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="agentCode",nullable=false)
    @JsonIgnoreProperties({"orders","hibernateLazyInitializer"})
    private Agents agent;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="customerCode",nullable=false)
    @JsonIgnoreProperties({"orders","hibernateLazyInitializer"})
    private Customer customer;

    public Orders()
    {
    }

    public Orders(double orderAmt, double advanceAmt, String orderDesc, Agents agent, Customer customer)
    {
        this.orderAmt = orderAmt;
        this.advanceAmt = advanceAmt;
        this.orderDesc = orderDesc;
        this.agent = agent;
        this.customer = customer;
    }

    public long getOrderNum()
    {
        return orderNum;
    }

    public void setOrderNum(long orderNum)
    {
        this.orderNum = orderNum;
    }

    public double getOrderAmt()
    {
        return orderAmt;
    }

    public void setOrderAmt(double orderAmt)
    {
        this.orderAmt = orderAmt;
    }

    public double getAdvanceAmt()
    {
        return advanceAmt;
    }

    public void setAdvanceAmt(double advanceAmt)
    {
        this.advanceAmt = advanceAmt;
    }

    public String getOrderDesc()
    {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc)
    {
        this.orderDesc = orderDesc;
    }

    public Agents getAgent()
    {
        return agent;
    }

    public void setAgent(Agents agent)
    {
        this.agent = agent;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(Customer customer)
    {
        this.customer = customer;
    }
}


