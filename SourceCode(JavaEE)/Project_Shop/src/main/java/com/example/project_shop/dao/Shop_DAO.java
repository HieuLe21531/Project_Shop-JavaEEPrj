package com.example.project_shop.dao;

import com.example.project_shop.entity.Shop;

import java.util.List;

public interface Shop_DAO {
    public boolean addShop (Shop shop);
    public boolean updateShop (Shop shop);
    public Shop findShopbyId (String id);
    public List<Shop> findAll ();
    public List<Shop> findbyName (String name);
}
