package com.microservice.Phone.mapper;

import com.microservice.Phone.dto.BrandDto;
import com.microservice.Phone.dto.ModelDto;
import com.microservice.Phone.model.Brand;
import com.microservice.Phone.model.Model;

public class PhoneMapper {
    public static ModelDto mapToModelDto(Model model) {
        return ModelDto.builder()
                .id(model.getId())
                .name(model.getName())
                .colour(model.getColour())
                .ram(model.getRam())
                .storage(model.getStorage())
                .frontCamera(model.getFrontCamera())
                .rearCamera(model.getRearCamera())
                .price(model.getPrice())
                .brandDto(mapToBrandDto(model.getBrand()))
                .build();
    }

    public static Model maptoModel(ModelDto modelDto) {
        return Model.builder()
                .name(modelDto.getName())
                .colour(modelDto.getColour())
                .ram(modelDto.getRam())
                .storage(modelDto.getStorage())
                .frontCamera(modelDto.getFrontCamera())
                .rearCamera(modelDto.getRearCamera())
                .price(modelDto.getPrice())
                .build();
    }

    public static BrandDto mapToBrandDto(Brand brand) {
        return BrandDto.builder()
                .id(brand.getId())
                .name(brand.getName())
                .build();
    }

    public static Brand mapToBrand(BrandDto brandDto) {
        return Brand.builder()
                .name(brandDto.getName())
                .build();
    }
}
