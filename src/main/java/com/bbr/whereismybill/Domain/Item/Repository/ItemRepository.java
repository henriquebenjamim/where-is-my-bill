package com.bbr.whereismybill.Domain.Item.Repository;

import com.bbr.whereismybill.Domain.Item.Model.Item;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Id> {
    Optional<Item> findById(Long id);
}
