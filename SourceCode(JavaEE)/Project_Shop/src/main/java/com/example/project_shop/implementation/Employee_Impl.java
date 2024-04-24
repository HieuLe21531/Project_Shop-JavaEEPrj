package com.example.project_shop.implementation;

import com.example.project_shop.dao.Employee_DAO;
import com.example.project_shop.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class Employee_Impl implements Employee_DAO {
    EntityManager entityManager;
    public Employee_Impl () {
        entityManager = Persistence.createEntityManagerFactory("jpa-mssql").createEntityManager();
    }
    @Override
    public boolean addEmployee(Employee employee) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.persist(employee);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.commit();
            entityManager.merge(employee);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            entityTransaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Employee findbyId(String id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee findbyPhone(String phone) {
        return entityManager.find(Employee.class, phone);
    }

    @Override
    public List<Employee> findAll() {
        return entityManager.createNamedQuery("Employee.findAll").getResultList();
    }

    @Override
    public List<Employee> findbyLastName(String name) {
        return entityManager.createNamedQuery("Employee.findbyLastName").setParameter("name","%"+name+"%").getResultList();
    }

    @Override
    public List<Employee> findbyShop(String id) {
        return entityManager.createNamedQuery("Employee.findAll_inShop").setParameter("id",id).getResultList();
    }
}
