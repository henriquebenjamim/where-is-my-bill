package com.bbr.whereismybill.service;

import com.bbr.whereismybill.exception.RecordNotFoundException;
import com.bbr.whereismybill.model.Order;
import com.bbr.whereismybill.repository.OrderRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Validated
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> list() {
        return orderRepository.findAll();
    }

    public Order findById(@PathVariable @NotNull UUID id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Order create(@Valid Order order) {
        return orderRepository.save(order);
    }

    public Order update(@NotNull UUID id, @Valid Order order) {
        return orderRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setCustomer(order.getCustomer());
                    recordFound.setRestaurantTable(order.getRestaurantTable());
                    recordFound.setServingStaff(order.getServingStaff());
                    recordFound.setStatus(order.getStatus());
                    return orderRepository.save(recordFound);
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public void delete(@PathVariable @NotNull UUID id) {
        orderRepository.delete(orderRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
