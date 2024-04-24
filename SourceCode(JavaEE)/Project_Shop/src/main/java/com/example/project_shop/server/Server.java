package com.example.project_shop.server;

import com.example.project_shop.dao.*;
import com.example.project_shop.entity.Order;
import com.example.project_shop.implementation.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    private static final String URL = "rmi://localhost:7878";
    public static void main(String[] args){
        try {
            Context context = new InitialContext();

            Customer_DAO customer_dao = new Customer_Impl();
            Employee_DAO employee_dao = new Employee_Impl();
            Order_DAO order_dao = new Order_Impl();
            Order_Detail_DAO detail_dao = new OrderDetail_Impl();
            Product_DAO product_dao = new Product_Impl();
            Product_inShop_DAO inShop_dao = new Product_inShop_Impl();
            Shop_DAO shop_dao = new Shop_Impl();
            Supplier_DAO supplier_dao = new Supplier_Impl();

            LocateRegistry.createRegistry(7878);
            context.bind(URL+"customer_dao", customer_dao);
            context.bind(URL+"employee_dao", employee_dao);
            context.bind(URL+"order_dao", order_dao);
            context.bind(URL+"detail_dao", detail_dao);
            context.bind(URL+"product_dao", product_dao);
            context.bind(URL+"inShop_dao", inShop_dao);
            context.bind(URL+"shop_dao", shop_dao);
            context.bind(URL+"supplier_dao", supplier_dao);

            System.out.println("Server is running");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
