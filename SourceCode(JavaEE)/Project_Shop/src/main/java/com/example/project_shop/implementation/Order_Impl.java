package com.example.project_shop.implementation;

import com.example.project_shop.dao.Order_DAO;
import com.example.project_shop.entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class Order_Impl implements Order_DAO {
    EntityManager entityManager;
    public Order_Impl () {
        entityManager = Persistence.createEntityManagerFactory("jpa-mssql").createEntityManager();
    }
    @Override
    public boolean addOrder(Order order) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(order);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateOrder(Order order) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(order);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Order findOrderbyId(String id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public List<Order> findAll() {
        return entityManager.createNamedQuery("Order.findAll").getResultList();
    }

    @Override
    public List<Order> findOrderbyCustomerId(String id) {
        return entityManager.createNamedQuery("Order.findOrderbyCustomerId").setParameter("id",id).getResultList();
    }

    @Override
    public List<Order> findOrderbyCustomerPhone(String phone) {
        return entityManager.createNamedQuery("Order.findOrderbyCustomerPhone").setParameter("phone",phone).getResultList();
    }

    @Override
    public List<Order> findOrderbyShop(String id) {
        return entityManager.createNamedQuery("Order.findOrderbyShop").setParameter("id",id).getResultList();
    }
}
