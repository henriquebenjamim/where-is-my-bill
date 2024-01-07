package com.bbr.whereismybill.controller;

import com.bbr.whereismybill.model.Order;
import com.bbr.whereismybill.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody @Valid Order order) {
        return new ResponseEntity<>(orderService.create(order), HttpStatus.CREATED);
    }

    @PostMapping("/{orderId}/menu-item/{menuItemOrderId}")
    public ResponseEntity<String> addItemToOrder(
            @PathVariable("orderId") UUID orderId,
            @PathVariable("menuItemOrderId") Long menuItemOrderId
    ) {
        try {
            orderService.addItemToOrder(orderId, menuItemOrderId);
            return ResponseEntity.ok("MenuItemOrder added to the Order with success!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errorto add MenuItemOrder to Order. ao adicionar MenuItemOrder ao Order: " + e.getMessage());
        }
    }

    @GetMapping("{id}")
    public Optional<Order> get(@PathVariable("id") UUID id) {
        return orderService.findById(id);
    }
}
