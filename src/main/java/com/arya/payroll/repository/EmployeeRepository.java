package com.arya.payroll.repository;

import com.arya.payroll.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public Employee findByEmployeeIdentifier(String employeeIdentifier);
}
