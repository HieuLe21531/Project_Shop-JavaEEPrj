package com.example.project_shop.implementation;

import com.example.project_shop.dao.Order_Detail_DAO;
import com.example.project_shop.entity.Order_Detail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class OrderDetail_Impl implements Order_Detail_DAO {
    EntityManager entityManager;
    public  OrderDetail_Impl () {
        entityManager = Persistence.createEntityManagerFactory("jpa-mssql").createEntityManager();
    }
    @Override
    public boolean addProducttoOrder(Order_Detail orderDetail) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(orderDetail);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateProducttoOrder(Order_Detail orderDetail) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.commit();
            entityManager.merge(orderDetail);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();;
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteProducttoOrder(String id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.commit();
            Order_Detail orderDetail = entityManager.find(Order_Detail.class, id);
            entityManager.remove(orderDetail);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Order_Detail> detailofOrder(String id) {
        return entityManager.createNamedQuery("OrderDetail.findAll").setParameter("id",id).getResultList();
    }
}
