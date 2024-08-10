package com.microservice.Order.clients;

import com.microservice.Order.external.Model;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PHONE")
public interface ModelClient {
    @GetMapping("/phones/model/{modelId}")
    public Model getModel(@PathVariable("modelId") Long modelId);
}
