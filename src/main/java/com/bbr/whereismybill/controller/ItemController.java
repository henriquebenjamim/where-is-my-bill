package com.bbr.whereismybill.controller;

import com.bbr.whereismybill.model.Item;
import com.bbr.whereismybill.service.ItemService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("api/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> list() {
        return itemService.list();
    }

    @GetMapping("/{id}")
    public Item findById(@PathVariable @NotNull @Positive Long id) {
        return itemService.findById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Item create(@RequestBody @Valid Item item) {
        return itemService.create(item);
    }

    @PutMapping("/{id}")
    public Item update(@PathVariable Long id, @RequestBody @Valid Item item) {
        return itemService.update(id, item);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        itemService.delete(id);
    }
}
