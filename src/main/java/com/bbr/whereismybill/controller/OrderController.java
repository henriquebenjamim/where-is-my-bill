package com.bbr.whereismybill.controller;

import com.bbr.whereismybill.model.Order;
import com.bbr.whereismybill.service.OrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> list() {
        return orderService.list();
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable @NotNull UUID id) {
        return orderService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Order create(@RequestBody @Valid Order order) {
        return orderService.create(order);
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable UUID id, @RequestBody @Valid Order order) {
        return orderService.update(id, order);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull UUID id) {
        orderService.delete(id);
    }
}
