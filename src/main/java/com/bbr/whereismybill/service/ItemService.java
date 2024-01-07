package com.bbr.whereismybill.service;

import com.bbr.whereismybill.model.Item;
import com.bbr.whereismybill.repository.ItemRepository;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Validated
@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> list() {
        return itemRepository.findAll();
    }

    public Item findById(@PathVariable @NotNull @Positive Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Item create(Item item) {
        return itemRepository.save(item);
    }

    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }
}
