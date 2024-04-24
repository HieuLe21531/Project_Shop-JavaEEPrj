package com.example.project_shop.implementation;

import com.example.project_shop.dao.Product_DAO;
import com.example.project_shop.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class Product_Impl implements Product_DAO {
    EntityManager entityManager;
    public Product_Impl () {
        entityManager = Persistence.createEntityManagerFactory("jpa-mssql").createEntityManager();
    }
    @Override
    public boolean addProduct(Product product) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(product);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(product);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product findproductbyId(String id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> findAll() {
        return entityManager.createNamedQuery("Product.findAll").getResultList();
    }

    @Override
    public List<Product> findbyName(String name) {
        return entityManager.createNamedQuery("Product.findbyName").setParameter("name","%"+name+"%").getResultList();
    }
}
