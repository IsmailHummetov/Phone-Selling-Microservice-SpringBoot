package com.microservice.Phone.controller;

import com.microservice.Phone.clients.ImageClient;
import com.microservice.Phone.dto.ModelDto;
import com.microservice.Phone.service.inter.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/phones")
@RequiredArgsConstructor
public class ModelController {

    private final ModelService modelService;
    private final ImageClient imageClient;

    @GetMapping("/models")
    public ResponseEntity<List<ModelDto>> getAllModels() {
        return ResponseEntity.ok(modelService.getAllModel());
    }

    @GetMapping("/model")
    public ResponseEntity<List<ModelDto>> getAllModelsByBrandId(
            @RequestParam("brandId") Long brandId) {
        if (modelService.getAllModelByBrandId(brandId) != null) {
            return ResponseEntity.ok(modelService.getAllModelByBrandId(brandId));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/model/{modelId}")
    public ResponseEntity<ModelDto> getModelById(@PathVariable Long modelId) {
        if (modelService.getModelById(modelId) != null)
            return ResponseEntity.ok(modelService.getModelById(modelId));
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/model")
    public ResponseEntity<String> createModel(
            @RequestParam("brandId") Long brandId,
            @RequestBody ModelDto modelDto) {
        if (modelService.createModel(brandId, modelDto)) {
            return new ResponseEntity<>("Model created Successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/model/{modelId}")
    public ResponseEntity<String> updateModel(
            @PathVariable Long modelId,
            @RequestBody ModelDto modelDto) {
        if (modelService.updateModel(modelId, modelDto))
            return ResponseEntity.ok("Model updated successfully");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/model/{modelId}")
    public ResponseEntity<String> deleteModel(
            @PathVariable Long modelId) {
        if (modelService.deleteModel(modelId))
            return ResponseEntity.ok("Model deleted successfully");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


}
