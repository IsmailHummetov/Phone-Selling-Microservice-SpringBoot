package com.microservice.Order.dto;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private String username;
    private String brandName;
    private String modelName;
    private String colour;
    private Integer ram;
    private Integer storage;
    private Double price;
    @Lob
    private byte[] data;
}
