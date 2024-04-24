package com.example.project_shop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString

@NamedQueries({
        @NamedQuery(name = "Supplier.findAll", query = "select su from Supplier su"),
        @NamedQuery(name = "Supplier.findbyName", query = "select su from  Supplier su where su.SupplierName like :name")
})

public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SupplierId")
    private String SupllierId;
    @Column(name = "SupplierName", nullable = false)
    private String SupplierName;
    @Column(name = "Supplier_Address", nullable = false)
    private String SupplierAddress;
    @Column(name = "CertificateId")
    private String CertificateId;
    @OneToMany(targetEntity = Product.class)
    private Set<Product> productSet;
}
