package com.bbr.whereismybill.Domain.Order.Repository;

import com.bbr.whereismybill.Domain.Order.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    Optional<Order> findById(UUID id);
}
