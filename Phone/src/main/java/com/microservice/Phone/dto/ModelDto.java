package com.microservice.Phone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelDto {
    private Long id;
    private String name;
    private String colour;
    private Integer ram;
    private Integer storage;
    private Double frontCamera;
    private Double rearCamera;
    private Double price;
    private BrandDto brandDto;
}
