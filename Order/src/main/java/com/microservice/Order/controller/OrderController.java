package com.microservice.Order.controller;

import com.microservice.Order.clients.ModelClient;
import com.microservice.Order.dto.BrandDto;
import com.microservice.Order.dto.ModelDto;
import com.microservice.Order.dto.OrderDto;
import com.microservice.Order.dto.UserDto;
import com.microservice.Order.external.Model;
import com.microservice.Order.mapper.OrderMapping;
import com.microservice.Order.service.inter.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final RestTemplate restTemplate = new RestTemplate();
    private final OrderService orderService;
    private final ModelClient modelClient;

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders(
            @RequestParam("username") String username) {
        return ResponseEntity.ok(orderService.getAllOrder(username));
    }

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestParam("modelId") Long modelId) {
        Model model = modelClient.getModel(modelId);
        OrderDto orderDto = OrderMapping.mapFromModelToOrderDto(model);

        String username = "nihad";
        if (orderService.createOrder(username, orderDto)) {
            return new ResponseEntity<>("Order created successfully",
                    HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<String> updateOrder(@PathVariable("orderId") Long orderId,
                                              @RequestBody OrderDto orderDto) {
        if (orderService.updateOrder(orderId, orderDto)) {
            return ResponseEntity.ok("Order updated successfully");
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable("orderId") Long orderId) {
        if (orderService.deleteOrder(orderId))
            return ResponseEntity.ok("Order deleted successfully");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
