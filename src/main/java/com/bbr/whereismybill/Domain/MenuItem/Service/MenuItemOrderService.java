package com.bbr.whereismybill.Domain.MenuItem.Service;

import com.bbr.whereismybill.Domain.MenuItem.Model.MenuItemOrder;
import com.bbr.whereismybill.Domain.MenuItem.Repository.MenuItemOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuItemOrderService {

    @Autowired
    private MenuItemOrderRepository menuItemRepository;

    public MenuItemOrder create(MenuItemOrder menuItemOrder) {
        return menuItemRepository.save(menuItemOrder);
    }

    public Optional<MenuItemOrder> findById(Long id) {
        return menuItemRepository.findById(id);
    }
}
