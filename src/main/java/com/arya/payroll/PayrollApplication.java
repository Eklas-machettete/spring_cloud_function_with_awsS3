package com.arya.payroll;

import com.arya.payroll.function.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PayrollApplication {

    public static void main(String[] args) {

        SpringApplication.run(PayrollApplication.class, args);
    }

    @Bean
    public EmployeeFunction exampleFunction() {
        return new EmployeeFunction();
    }

    @Bean
    public EmployeeConsumer employeeConsumer() {
        return new EmployeeConsumer();
    }

    @Bean
    public EmployeeSupplier exampleSupplier() {
        return new EmployeeSupplier();
    }

    @Bean
    public EmployeeFileUploadConsumer employeeFileUploadConsumer() {
        return new EmployeeFileUploadConsumer();
    }
    @Bean
    public EmployeeFileDownloadFunction employeeFileDownloadFunction() {
        return new EmployeeFileDownloadFunction();
    }

}
