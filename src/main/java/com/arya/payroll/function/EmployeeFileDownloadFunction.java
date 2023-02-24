package com.arya.payroll.function;

import com.arya.payroll.entity.Employee;
import com.arya.payroll.repository.EmployeeRepository;
import com.arya.payroll.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.function.Function;

@Slf4j
public class EmployeeFileDownloadFunction implements Function<String, byte[]> {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private FileService fileService;

    @Override
    public byte[] apply(String s) {
        Optional<Employee> employeeOptional = employeeRepository.findById(Long.valueOf(s));
        if (employeeOptional.isPresent()) {
            return fileService.downloadFile(employeeOptional.get().getReportFileURL());
        }
        log.error("Employee not found with id: " + s);
        return null;
    }
}
