package com.example.project_shop.dao;

import com.example.project_shop.entity.Customer;

import java.util.List;

public interface Customer_DAO {
    public boolean addCustomer (Customer customer);
    public boolean updateCustomer (Customer customer);
    public List<Customer> findbyPhone (String phone);
    public List<Customer> findAll();
}
