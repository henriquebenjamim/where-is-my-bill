package com.bbr.whereismybill.Domain.Item.Controller;

import com.bbr.whereismybill.Domain.Item.Model.Item;
import com.bbr.whereismybill.Domain.Item.Service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> create(@RequestBody @Valid Item item) {
        return new ResponseEntity<>(itemService.create(item), HttpStatus.CREATED);
    }
}
