package com.example.project_shop.dao;

import com.example.project_shop.entity.Supplier;

import java.util.List;

public interface Supplier_DAO {
    public boolean addSupplier (Supplier supplier);
    public boolean updateSupplier (Supplier supplier);
    public Supplier findbyId (String id);
    public List<Supplier> findAll ();
    public List<Supplier> findbyName (String name);
}
