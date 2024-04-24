package com.example.project_shop.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString

@NamedQueries({
        @NamedQuery(name = "Product.findAll", query = "select p.ProductId, p.ProductName, p.Price, p.ProductStatus, su.SupplierName from Product p join p.supplier su"),
        @NamedQuery(name = "Product.findbyName", query = "select p from Product p where p.ProductName like :name")
})

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private String ProductId;
    @Column(name = "ProductName", nullable = false)
    private String ProductName;
    @Column(name = "Price")
    private double Price;
    @Column(name = "ProductStatus", nullable = false)
    private boolean ProductStatus;
    @ManyToOne(targetEntity = Supplier.class)
    @JoinColumn(name = "Supplier_ID", nullable = false)
    private Supplier supplier;
}
