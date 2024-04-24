package com.example.project_shop.implementation;

import com.example.project_shop.dao.Shop_DAO;
import com.example.project_shop.entity.Shop;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class Shop_Impl implements Shop_DAO {
    EntityManager entityManager;
    public Shop_Impl () {
        entityManager = Persistence.createEntityManagerFactory("jpa-mssql").createEntityManager();
    }
    @Override
    public boolean addShop(Shop shop) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(shop);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateShop(Shop shop) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(shop);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Shop findShopbyId(String id) {
        return entityManager.find(Shop.class, id);
    }

    @Override
    public List<Shop> findAll() {
        return entityManager.createNamedQuery("Shop.findAll").getResultList();
    }

    @Override
    public List<Shop> findbyName(String name) {
        return entityManager.createNamedQuery("Shop.findbyName").setParameter("name","%"+name+"%").getResultList();
    }
}
