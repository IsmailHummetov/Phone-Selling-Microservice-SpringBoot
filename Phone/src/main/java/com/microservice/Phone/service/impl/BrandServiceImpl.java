package com.microservice.Phone.service.impl;

import com.microservice.Phone.dto.BrandDto;
import com.microservice.Phone.mapper.PhoneMapper;
import com.microservice.Phone.model.Brand;
import com.microservice.Phone.repository.BrandRepository;
import com.microservice.Phone.service.inter.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Override
    public boolean createBrand(BrandDto brandDto) {
        brandRepository.save(PhoneMapper.mapToBrand(brandDto));
        return true;
    }

    @Override
    public boolean updateBrand(Long brandId, BrandDto brandDto) {
        if (brandRepository.existsById(brandId)){
            Brand brand = brandRepository.findById(brandId).orElse(null);
            brand.setName(brandDto.getName());
            brandRepository.save(brand);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBrand(Long brandId) {
        if (brandRepository.existsById(brandId))
        {
            brandRepository.deleteById(brandId);
            return true;
        }
        return false;
    }

    @Override
    public List<BrandDto> getAllBrand() {
        return brandRepository.findAll().stream()
                .map(PhoneMapper::mapToBrandDto)
                .collect(Collectors.toList());
    }

    @Override
    public BrandDto getBrandById(Long brandId) {
        Brand brand = brandRepository.findById(brandId).orElse(null);
        if (brand != null) {
            return PhoneMapper.mapToBrandDto(brand);
        }
        return null;
    }

}
