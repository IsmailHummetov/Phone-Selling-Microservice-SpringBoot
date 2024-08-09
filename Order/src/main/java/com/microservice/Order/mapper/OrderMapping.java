package com.microservice.Order.mapper;

import com.microservice.Order.dto.ModelDto;
import com.microservice.Order.dto.OrderDto;
import com.microservice.Order.model.Order;

public class OrderMapping {
    public static Order mapToOrder(OrderDto orderDto){
        return Order.builder()
                .username(orderDto.getUsername())
                .brandName(orderDto.getBrandName())
                .modelName(orderDto.getModelName())
                .colour(orderDto.getColour())
                .storage(orderDto.getStorage())
                .ram(orderDto.getRam())
                .price(orderDto.getPrice())
                .build();
    }
    public static OrderDto mapToOrderDto(Order order){
        return OrderDto.builder()
                .id(order.getId())
                .username(order.getUsername())
                .brandName(order.getBrandName())
                .modelName(order.getModelName())
                .colour(order.getColour())
                .storage(order.getStorage())
                .ram(order.getRam())
                .price(order.getPrice())
                .build();
    }
    public static OrderDto mapFromModelDtoToOrderDto(ModelDto modelDto){
        return OrderDto.builder()
                .id(modelDto.getId())
                .brandName(modelDto.getBrandDto().getName())
                .modelName(modelDto.getName())
                .colour(modelDto.getColour())
                .storage(modelDto.getStorage())
                .ram(modelDto.getRam())
                .price(modelDto.getPrice())
                .build();
    }
}
