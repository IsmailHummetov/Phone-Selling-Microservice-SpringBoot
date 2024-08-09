package com.microservice.Order.service.impl;

import com.microservice.Order.dto.OrderDto;
import com.microservice.Order.mapper.OrderMapping;
import com.microservice.Order.model.Order;
import com.microservice.Order.repository.OrderRepository;
import com.microservice.Order.service.inter.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public boolean createOrder(String username, OrderDto orderDto) {
        try {
            Order order = OrderMapping.mapToOrder(orderDto);
            order.setUsername(username);
            orderRepository.save(order);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean updateOrder(Long orderId, OrderDto orderDto) {
        if (orderRepository.existsById(orderId)){
            Order order = orderRepository.findById(orderId).get();
            order.setBrandName(orderDto.getBrandName());
            order.setModelName(orderDto.getModelName());
            order.setColour(orderDto.getColour());
            order.setRam(orderDto.getRam());
            order.setStorage(orderDto.getStorage());
            order.setPrice(orderDto.getPrice());
            order.setData(orderDto.getData());
            orderRepository.save(order);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteOrder(Long orderId) {
        if (orderRepository.existsById(orderId)){
            orderRepository.deleteById(orderId);
            return true;
        }
        return false;
    }

    @Override
    public List<OrderDto> getAllOrder(String username) {
        return orderRepository.findByUsername(username)
                .stream().map(OrderMapping::mapToOrderDto)
                .toList();
    }
}
