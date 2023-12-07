package com.bbr.whereismybill.Domain.MenuItem.Repository;

import com.bbr.whereismybill.Domain.MenuItem.Model.MenuItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuItemOrderRepository extends JpaRepository<MenuItemOrder, Long> {

    Optional<MenuItemOrder> findById(Long id);
}
