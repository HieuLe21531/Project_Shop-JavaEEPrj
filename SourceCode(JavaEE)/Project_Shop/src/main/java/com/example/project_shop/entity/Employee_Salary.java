package com.example.project_shop.entity;

import jakarta.persistence.*;
import lombok.*;
import org.glassfish.jaxb.core.v2.model.core.ID;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Employee_Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Position")
    private String Position;
    @Column(name = "Salary", nullable = false)
    private double Salary;
}
