package com.bbr.whereismybill.Domain.Order.Service;

import com.bbr.whereismybill.Domain.Order.Model.Order;
import com.bbr.whereismybill.Domain.Order.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> findById(UUID id) {
        return orderRepository.findById(id);
    }
}
