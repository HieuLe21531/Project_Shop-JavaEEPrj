package com.example.project_shop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "Order")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString

@NamedQueries({
        @NamedQuery(name = "Order.findAll", query = "select o from Order o"),
        @NamedQuery(name = "Order.findOrderbyCustomerId", query = "select o from Order o join o.customer c where c.PersonalId like :id"),
        @NamedQuery(name = "Order.findOrderbyCustomerPhone", query = "select o from Order o join o.customer c where c.Phone like :phone"),
        @NamedQuery(name = "Order.findOrderbyShop", query = "select o from Order o join o.shop s where s.ShopId like :id")
})

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderId")
    private String OrderId;
    @ManyToOne
    @JoinColumn(name = "CustomerId", referencedColumnName = "CustomerID")
    private Customer customer;
    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "ShopId")
    private Shop shop;
    @Column(name = "OrderTime")
    private LocalDateTime OrderTime;
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus orderStatus;
}
