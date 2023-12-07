package com.bbr.whereismybill.Domain.Item.Service;

import com.bbr.whereismybill.Domain.Item.Model.Item;
import com.bbr.whereismybill.Domain.Item.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item create(Item item) {
        return itemRepository.save(item);
    }

    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }
}
