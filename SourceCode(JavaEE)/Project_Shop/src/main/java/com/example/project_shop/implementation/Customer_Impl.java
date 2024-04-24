package com.example.project_shop.implementation;

import com.example.project_shop.dao.Customer_DAO;
import com.example.project_shop.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class Customer_Impl implements Customer_DAO {
    EntityManager entityManager;
    public Customer_Impl () {
        entityManager = Persistence.createEntityManagerFactory("jpa-mssql").createEntityManager();
    }
    @Override
    public boolean addCustomer(Customer customer) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(customer);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(customer);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Customer> findbyPhone(String phone) {
        return entityManager.createNamedQuery("Customer.findbyPhone", Customer.class).setParameter("phone","%"+phone+"%").getResultList();
    }

    @Override
    public List<Customer> findAll() {
        return entityManager.createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }
}
