package com.example.project_shop.dao;

import com.example.project_shop.entity.Order;

import java.util.List;

public interface Order_DAO {
    public boolean addOrder (Order order);
    public boolean updateOrder (Order order);
    public Order findOrderbyId (String id);
    public List<Order> findAll ();
    public List<Order> findOrderbyCustomerId (String id);
    public List<Order> findOrderbyCustomerPhone (String phone);
    public List<Order> findOrderbyShop (String id);
}
