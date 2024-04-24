package com.example.project_shop.dao;

import com.example.project_shop.entity.Product_inShop;

import java.util.List;

public interface Product_inShop_DAO {
    public boolean addNewProducttoShop (Product_inShop productInShop);
    public boolean updateProductinShop (Product_inShop productInShop);
    public List<Product_inShop> findQuantity (String id1, String id2);
    public List<Product_inShop> findAllProduct_inSpecificShop (String id);
    public List<Product_inShop> findSpecificProduct_inAllShop (String id);
}
