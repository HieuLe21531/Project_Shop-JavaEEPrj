package com.example.project_shop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Employee")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString

@NamedQueries({
        @NamedQuery(name = "Employee.findAll", query = "select e from Employee e"),
        @NamedQuery(name = "Employee.findbyLastName", query = "select e, es.Salary from Employee e join e.employeeSalary es where e.LastName like :name"),
        @NamedQuery(name = "Employee.findAll_inShop", query = "select e, es.Salary from Employee e join e.employeeSalary es join e.shop s where s.ShopId like :id")
})

public class Employee extends Person implements Serializable {
    @ManyToOne
    @JoinColumn(name = "ShopID")
    private Shop shop;
    @ManyToOne
    @JoinColumn(name = "Position")
    private Employee_Salary employeeSalary;
    private LocalDate StartDate;
    @Enumerated(EnumType.ORDINAL)
    private EmployeeStatus employeeStatus;
    @OneToMany(targetEntity = Order.class)
    private Set<Order> orderSet;
}
