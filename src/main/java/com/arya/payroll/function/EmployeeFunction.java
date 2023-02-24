package com.arya.payroll.function;
import com.arya.payroll.entity.Employee;
import com.arya.payroll.repository.EmployeeRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Function;
import java.util.Optional;


@NoArgsConstructor
public class EmployeeFunction implements Function<Long, Employee>  {
    @Autowired
    private EmployeeRepository employeeRepository;
    public Employee apply (Long s)
    {
        Optional<Employee> employeeOptional = employeeRepository.findById(s);
        if (employeeOptional.isPresent()) {
            return employeeOptional.get();
        }
        return null;
    }
}
