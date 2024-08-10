package com.microservice.Image.service.inter;

import com.microservice.Image.model.FileDB;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface FileStorageService {
    public FileDB store(MultipartFile file, Long phoneId) throws IOException;
    public FileDB getFile(Long phoneId);
    public Stream<FileDB> getAllFiles();
    public boolean deleteFile(Long phoneId);
}
