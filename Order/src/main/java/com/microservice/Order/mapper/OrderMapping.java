package com.microservice.Order.mapper;

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
                .data(orderDto.getData())
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
                .data(order.getData())
                .build();
    }
}
