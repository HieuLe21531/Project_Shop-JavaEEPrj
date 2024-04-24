package com.example.project_shop.dao;

import com.example.project_shop.entity.Order_Detail;
import com.example.project_shop.entity.Product_inShop;

import java.util.List;

public interface Order_Detail_DAO {
    public boolean addProducttoOrder (Order_Detail orderDetail);
    public boolean updateProducttoOrder (Order_Detail orderDetail);
    public boolean deleteProducttoOrder (String id);
    public List<Order_Detail> detailofOrder (String id);
}
