package com.example.project_shop.dao;

import com.example.project_shop.entity.Employee;

import java.util.List;

public interface Employee_DAO {
    public boolean addEmployee (Employee employee);
    public boolean updateEmployee (Employee employee);
    public Employee findbyId (String id);
    public Employee findbyPhone (String phone);
    public List<Employee> findAll ();
    public List<Employee> findbyLastName (String name);
    public List<Employee> findbyShop (String id);
}
