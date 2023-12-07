package com.bbr.whereismybill.Domain.Order.Model;



import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.bbr.whereismybill.Domain.MenuItem.Model.MenuItemOrder;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name = "orders")
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String customer;

    @Column(name = "restaurant_table")
    private int restaurantTable;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<MenuItemOrder> menuItems;

    @Column(name = "serving_staff")
    private String servingStaff;

    @Column(name = "created_at")
    private String createdAt;


    public Order() {
    }

    public Order(UUID id, String customer, int restaurantTable, String servingStaff,
                 String createdAt) {
        this.id = id;
        this.customer = customer;
        this.restaurantTable = restaurantTable;
        this.servingStaff = servingStaff;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getRestaurantTable() {
        return restaurantTable;
    }

    public void setRestaurantTable(int restaurantTable) {
        this.restaurantTable = restaurantTable;
    }

    public String getServingStaff() {
        return servingStaff;
    }

    public void setServingStaff(String servingStaff) {
        this.servingStaff = servingStaff;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public List<MenuItemOrder> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItemOrder> menuItems) {
        this.menuItems = menuItems;
    }

    public List<MenuItemOrder> getMenuItemOrders() {
        return menuItems;
    }

    public void setMenuItemOrders(List<MenuItemOrder> menuItem) {
        this.menuItems = menuItem;
    }
}

