package com.arya.payroll.function;

import com.arya.payroll.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.util.function.Consumer;

public class EmployeeFileUploadConsumer implements Consumer<MultipartFile> {
    @Autowired
    private FileService fileService;

    @Override
    public void accept(MultipartFile multipartFile) {
        fileService.uploadFile(multipartFile);
    }
}
