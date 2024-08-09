package com.microservice.Image.service.impl;

import com.microservice.Image.model.FileDB;
import com.microservice.Image.repository.FileDBRepository;
import com.microservice.Image.service.inter.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class FileStorageServiceImpl implements FileStorageService {

    private final FileDBRepository fileDBRepository;

    @Override
    @Transactional
    public FileDB store(MultipartFile file, Long phoneId) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileDB fileDB = new FileDB(fileName,file.getContentType(),file.getBytes(),phoneId);
        return fileDBRepository.save(fileDB);
    }

    @Override
    @Transactional(readOnly = true)
    public FileDB getFile(Long phoneId) {
        return fileDBRepository.findByPhoneId(phoneId).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Stream<FileDB> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }
}
