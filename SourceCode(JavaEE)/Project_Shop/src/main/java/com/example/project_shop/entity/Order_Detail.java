package com.example.project_shop.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString

@NamedQueries({
        @NamedQuery(name = "OrderDetail.findAll", query = "select p.ProductId, p.ProductName, od.Quantity from Order_Detail od join od.order o join od.product p where o.OrderId like :id")
})

public class Order_Detail {
    @Id
    @ManyToOne
    @JoinColumn(name = "OrderId")
    private Order order;
    @Id
    @ManyToOne
    @JoinColumn(name = "ProductId")
    private Product product;
    private int Quantity;
}
