package com.example.project_shop.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString

@NamedQueries({
        @NamedQuery(name = "Product_inShop.findQuantity", query = "select ps.Remain_inStore from Product_inShop ps join ps.product p join ps.shop s where p.ProductId like :id1 and s.ShopId like :id2"),
        @NamedQuery(name = "Product_inShop.findAllProduct_inSpecificShop", query = "select p.ProductId, p.ProductName, ps.Remain_inStore from Product_inShop ps join ps.product p join ps.shop s where s.ShopId like :id"),
        @NamedQuery(name = "Product_inShop.findSpecificProduct_inAllShop", query = "select s.ShopId, s.ShopName, ps.Remain_inStore from Product_inShop ps join ps.product p join  ps.shop s where p.ProductId like :id")
})

public class Product_inShop {
    @Id
    @ManyToOne
    @JoinColumn(name = "ProductId")
    private Product product;
    @Id
    @ManyToOne
    @JoinColumn(name = "ShopId")
    private Shop shop;
    private int Remain_inStore;
}
