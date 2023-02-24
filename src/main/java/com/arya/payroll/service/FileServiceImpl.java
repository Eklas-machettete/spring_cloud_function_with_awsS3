package com.arya.payroll.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.arya.payroll.util.ConvertToFile;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


@Service
@RequiredArgsConstructor
@Slf4j
public class FileServiceImpl implements FileService {
    @Value("${application.bucket.name}")
    private String bucketName;
    private final ConvertToFile convertToFile;
    private final AmazonS3 amazonS3Client;

    @Override
    public String uploadFile(MultipartFile multipartFile) {
        File file = convertToFile.convertMultipartFileToFile(multipartFile);
        String fileName = "arya_" + "employee_" + System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
        amazonS3Client.putObject(new PutObjectRequest(bucketName, fileName, file));
        file.delete();
        return fileName;

    }

    @Override
    public byte[] downloadFile(String fileName) {
        try {
            S3Object s3Object = amazonS3Client.getObject(bucketName, fileName);
            S3ObjectInputStream inputStream = s3Object.getObjectContent();
            byte[] file = IOUtils.toByteArray(inputStream);
            return file;
        } catch (Exception e) {
            log.error("File is not belongs in s3 bucket with name: +" + fileName);
        }
        return null;
    }

    @Override
    public Boolean deleteFile(String fileName) {
        try {
            amazonS3Client.deleteObject(bucketName, fileName);
            log.info("successfully deleted file with name: " + fileName);
            return true;
        } catch (Exception e) {
            log.info("deleted file with name: " + fileName + " failed");
            log.info(e.getMessage());
        }
        return false;
    }
}
