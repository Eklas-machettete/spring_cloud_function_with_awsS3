package com.arya.payroll.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {


    @Id
    @GeneratedValue(generator = "UUID")
    private Long id;

    private String name;

    private int employeeIdentifier;

    private String email;

    private String salary;

    public Employee(String name, int employeeIdentifier, String email, String salary) {
        this.name = name;
        this.employeeIdentifier = employeeIdentifier;
        this.email = email;
        this.salary = salary;
        this.salary = salary;
    }

    // private String imageURL;
    private String reportFileURL;

}
