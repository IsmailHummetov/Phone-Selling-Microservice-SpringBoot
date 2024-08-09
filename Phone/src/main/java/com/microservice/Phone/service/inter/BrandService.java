package com.microservice.Phone.service.inter;

import com.microservice.Phone.dto.BrandDto;

import java.util.List;

public interface BrandService {
    List<BrandDto> getAllBrand();
    BrandDto getBrandById(Long brandId);
    boolean createBrand(BrandDto brandDto);
    boolean updateBrand(Long brandId, BrandDto brandDto);
    boolean deleteBrand(Long brandId);
}
