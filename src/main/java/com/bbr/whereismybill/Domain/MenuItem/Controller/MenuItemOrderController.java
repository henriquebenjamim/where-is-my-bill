package com.bbr.whereismybill.Domain.MenuItem.Controller;

import com.bbr.whereismybill.Domain.MenuItem.Model.MenuItemOrder;
import com.bbr.whereismybill.Domain.MenuItem.Service.MenuItemOrderService;
import com.bbr.whereismybill.Domain.Order.Model.Order;
import com.bbr.whereismybill.Domain.Order.Service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/menuItemOrder/")
public class MenuItemOrderController {

    @Autowired
    private MenuItemOrderService menuItemOrderService;

    @PostMapping
    public ResponseEntity<MenuItemOrder> create(@RequestBody @Valid MenuItemOrder menuItemOrder) {
        return new ResponseEntity<>(menuItemOrderService.create(menuItemOrder), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public Optional<MenuItemOrder> get(@PathVariable("id") Long id) {
        return menuItemOrderService.findById(id);
    }
}
