package com.arya.payroll.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public String uploadFile(MultipartFile multipartFile);

    public byte[] downloadFile(String fileName);

    public Boolean deleteFile(String fileName);
}
