package com.bbr.whereismybill.repository;

import com.bbr.whereismybill.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    Optional<Order> findById(UUID id);
}
