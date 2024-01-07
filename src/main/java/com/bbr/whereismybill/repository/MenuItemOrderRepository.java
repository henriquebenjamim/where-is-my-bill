package com.bbr.whereismybill.repository;

import com.bbr.whereismybill.model.MenuItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuItemOrderRepository extends JpaRepository<MenuItemOrder, Long> {

    Optional<MenuItemOrder> findById(Long id);
}
