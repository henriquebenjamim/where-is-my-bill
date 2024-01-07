package com.bbr.whereismybill.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity(name = "menuItemOrders")
@Table(name = "menuItemOrders")
public class MenuItemOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    private int quantity;

    public MenuItemOrder() {
    }

    public MenuItemOrder(Long id, UUID orderId, Long itemId, int quantity) {
        this.id = id;
        this.order = new Order();
        this.order.setId(orderId); // Defina o ID do Order

        this.item = new Item();
        this.item.setId(itemId); // Defina o ID do Item

        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
