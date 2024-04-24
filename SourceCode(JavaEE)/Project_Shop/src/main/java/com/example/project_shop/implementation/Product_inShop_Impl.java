package com.example.project_shop.implementation;

import com.example.project_shop.dao.Product_inShop_DAO;
import com.example.project_shop.entity.Product_inShop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class Product_inShop_Impl implements Product_inShop_DAO {
    EntityManager entityManager;
    public Product_inShop_Impl () {
        entityManager = Persistence.createEntityManagerFactory("jpa-mssql").createEntityManager();
    }
    @Override
    public boolean addNewProducttoShop(Product_inShop productInShop) {
        EntityTransaction entityTransaction= entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(productInShop);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateProductinShop(Product_inShop productInShop) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(productInShop);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product_inShop> findQuantity(String id1, String id2) {
        return entityManager.createNamedQuery("Product_inShop.findQuantity").setParameter("id1",id1).setParameter("id2",id2).getResultList();
    }

    @Override
    public List<Product_inShop> findAllProduct_inSpecificShop(String id) {
        return entityManager.createNamedQuery("Product_inShop.findAllProduct_inSpecificShop").setParameter("id",id).getResultList();
    }

    @Override
    public List<Product_inShop> findSpecificProduct_inAllShop(String id) {
        return entityManager.createNamedQuery("Product_inShop.findSpecificProduct_inAllShop").setParameter("id",id).getResultList();
    }
}
