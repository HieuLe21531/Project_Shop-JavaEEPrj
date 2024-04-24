package com.example.project_shop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Customer")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString

@NamedQueries({
        @NamedQuery(name = "Customer.findbyPhone", query = "SELECT c from Customer c where c.Phone like :phone"),
        @NamedQuery(name = "Customer.findAll", query = "select  c from Customer c")
})

public class Customer extends Person implements Serializable {
    private double BonusPoint;
    @OneToMany(targetEntity = Order.class)
    private Set<Order> orderSet_Cust;
}
