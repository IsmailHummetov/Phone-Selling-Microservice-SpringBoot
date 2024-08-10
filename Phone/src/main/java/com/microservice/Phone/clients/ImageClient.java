package com.microservice.Phone.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "IMAGE")
public interface ImageClient {
    @DeleteMapping("/files/{phoneId}")
    public void delete(@PathVariable("phoneId") Long phoneId);
}
