package com.example.project_shop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString

@NamedQueries({
        @NamedQuery(name = "Shop.findAll", query = "select s from Shop s"),
        @NamedQuery(name = "Shop.findbyName", query = "select s from Shop s where s.ShopName like :id or s.Address like :id")
})

public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShopId")
    private String ShopId;
    @Column(name = "ShopName")
    private String ShopName;
    @Column(name = "Address")
    private String Address;
    @Column(name = "ShopStatus")
    private boolean ShopStatus;
    @OneToMany
    private Set<Order> orderSet_Shop;
    @OneToMany(targetEntity = Employee.class)
    private Set<Employee> employeeSet;
}
