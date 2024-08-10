package com.microservice.Order.mapper;

import com.microservice.Order.dto.ModelDto;
import com.microservice.Order.dto.OrderDto;
import com.microservice.Order.external.Model;
import com.microservice.Order.model.Order;

public class OrderMapping {
    public static Order mapToOrder(OrderDto orderDto){
        return Order.builder()
                .username(orderDto.getUsername())
                .phoneId(orderDto.getPhoneId())
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
                .phoneId(order.getPhoneId())
                .username(order.getUsername())
                .brandName(order.getBrandName())
                .modelName(order.getModelName())
                .colour(order.getColour())
                .storage(order.getStorage())
                .ram(order.getRam())
                .price(order.getPrice())
                .build();
    }
    public static OrderDto mapFromModelToOrderDto(Model model){
        return OrderDto.builder()
                .phoneId(model.getId())
                .brandName(model.getBrandDto().getName())
                .modelName(model.getName())
                .colour(model.getColour())
                .storage(model.getStorage())
                .ram(model.getRam())
                .price(model.getPrice())
                .build();
    }
}
