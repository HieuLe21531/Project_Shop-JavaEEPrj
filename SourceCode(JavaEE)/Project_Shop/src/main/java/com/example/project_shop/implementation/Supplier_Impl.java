package com.example.project_shop.implementation;

import com.example.project_shop.dao.Supplier_DAO;
import com.example.project_shop.entity.Supplier;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class Supplier_Impl implements Supplier_DAO {
    EntityManager entityManager;
    public Supplier_Impl () {
        entityManager = Persistence.createEntityManagerFactory("jpa-mssql").createEntityManager();
    }
    @Override
    public boolean addSupplier(Supplier supplier) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(supplier);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(supplier);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Supplier findbyId(String id) {
        return entityManager.find(Supplier.class, id);
    }

    @Override
    public List<Supplier> findAll() {
        return entityManager.createNamedQuery("Supplier.findAll").getResultList();
    }

    @Override
    public List<Supplier> findbyName(String name) {
        return entityManager.createNamedQuery("Supplier.findbyName").setParameter("name", "%"+name+"%").getResultList();
    }
}
