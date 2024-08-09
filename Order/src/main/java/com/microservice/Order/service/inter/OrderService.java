package com.microservice.Order.service.inter;

import com.microservice.Order.dto.OrderDto;

import java.util.List;

public interface OrderService {
    boolean createOrder(String username,OrderDto orderDto);
    boolean updateOrder(Long orderId, OrderDto orderDto);
    boolean deleteOrder(Long orderId);
    List<OrderDto> getAllOrder(String username);
}
