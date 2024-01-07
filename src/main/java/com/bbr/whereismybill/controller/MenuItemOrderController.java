package com.bbr.whereismybill.controller;

import com.bbr.whereismybill.model.MenuItemOrder;
import com.bbr.whereismybill.service.MenuItemOrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
