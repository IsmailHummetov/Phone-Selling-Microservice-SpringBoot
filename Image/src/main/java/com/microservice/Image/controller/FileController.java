package com.microservice.Image.controller;

import com.microservice.Image.message.ResponseFile;
import com.microservice.Image.message.ResponseMessage;
import com.microservice.Image.model.FileDB;
import com.microservice.Image.service.inter.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileStorageService fileStorageService;

    @PostMapping("/upload/{phoneId}")
    public ResponseEntity<ResponseMessage> uploadFile(
            @RequestParam("file") MultipartFile file,
            @PathVariable("phoneId") Long phoneId) {
        String message = "";
        try {
            fileStorageService.store(file, phoneId);
            message = "File uploaded successfully: " + file.getOriginalFilename();
            return new ResponseEntity<>(new ResponseMessage(message), HttpStatus.CREATED);
        } catch (IOException e) {
            message = "Could not upload file: " + file.getOriginalFilename();
            return new ResponseEntity<>(new ResponseMessage(message), HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<ResponseFile>> getFiles() {
        List<ResponseFile> files = fileStorageService.getAllFiles().map(dbFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(String.valueOf(dbFile.getPhoneId()))
                    .toUriString();

            return new ResponseFile(
                    dbFile.getName(),
                    fileDownloadUri,
                    dbFile.getType(),
                    dbFile.getData().length,
                    dbFile.getPhoneId());
        }).collect(Collectors.toList());

        return ResponseEntity.ok(files);
    }

    @GetMapping("/files/{phoneId}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long phoneId) throws IOException {
        FileDB fileDB = fileStorageService.getFile(phoneId);
        if (fileDB != null) {

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);
            headers.setContentType(MediaType.IMAGE_PNG);

            return new ResponseEntity<>(fileDB.getData(), headers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
//                .body(fileDB.getData());
    }
}
