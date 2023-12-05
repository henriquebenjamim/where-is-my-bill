package com.bbr.whereismybill.Domain.Order.Controller;

import com.bbr.whereismybill.Domain.Order.Model.Order;
import com.bbr.whereismybill.Domain.Order.Service.OrderService;
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

    @GetMapping("{id}")
    public Optional<Order> get(@PathVariable("id") UUID id) {
        return orderService.findById(id);
    }
}
