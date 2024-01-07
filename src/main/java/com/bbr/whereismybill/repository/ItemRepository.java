package com.bbr.whereismybill.repository;

import com.bbr.whereismybill.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
