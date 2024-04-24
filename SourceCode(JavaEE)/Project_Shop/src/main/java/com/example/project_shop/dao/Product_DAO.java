package com.example.project_shop.dao;

import com.example.project_shop.entity.Product;

import java.util.List;

public interface Product_DAO {
    public boolean addProduct (Product product);
    public boolean updateProduct (Product product);
    public Product findproductbyId (String id);
    public List<Product> findAll ();
    public List<Product> findbyName (String name);
}
