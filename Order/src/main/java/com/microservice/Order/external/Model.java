package com.microservice.Order.external;

import com.microservice.Order.dto.BrandDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Model {
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