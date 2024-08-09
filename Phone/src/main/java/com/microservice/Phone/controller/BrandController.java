package com.microservice.Phone.controller;

import com.microservice.Phone.dto.BrandDto;
import com.microservice.Phone.service.inter.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phones")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @GetMapping("/brands")
    public ResponseEntity<List<BrandDto>> getAllBrand() {
        return ResponseEntity.ok(brandService.getAllBrand());
    }

    @GetMapping("/brands/{brandId}")
    public ResponseEntity<BrandDto> getBrandById(
            @PathVariable("brandId") Long brandId) {
        if (brandService.getBrandById(brandId) != null) {
            return ResponseEntity.ok(brandService.getBrandById(brandId));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/brands")
    public ResponseEntity<String> createBrand(@RequestBody BrandDto brandDto) {
        brandService.createBrand(brandDto);
        return new ResponseEntity<>("Brand Created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/brands/{brandId}")
    public ResponseEntity<String> updateBrand(
            @PathVariable Long brandId,
            @RequestBody BrandDto brandDto) {
        if (brandService.updateBrand(brandId, brandDto))
            return ResponseEntity.ok("Brand updated successfully");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/brands/{brandId}")
    public ResponseEntity<String> deleteBrand(@PathVariable Long brandId) {
        if (brandService.deleteBrand(brandId))
            return ResponseEntity.ok("Brand deleted successfully");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
