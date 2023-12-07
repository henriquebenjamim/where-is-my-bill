package com.bbr.whereismybill.Domain.Order.Service;

import com.bbr.whereismybill.Domain.MenuItem.Model.MenuItemOrder;
import com.bbr.whereismybill.Domain.MenuItem.Repository.MenuItemOrderRepository;
import com.bbr.whereismybill.Domain.Order.Model.Order;
import com.bbr.whereismybill.Domain.Order.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MenuItemOrderRepository menuItemOrderRepository;

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    public void addItemToOrder(Order orderId, Long menuItemOrderId) {
        if (menuItemOrderRepository != null) {
            Optional<MenuItemOrder> menuItemOrder = menuItemOrderRepository.findById(menuItemOrderId);
        }

    }

    public void addItemToOrder(UUID orderId, Long menuItemOrderId) {

        if (menuItemOrderRepository != null && orderRepository != null) {
            Optional<Order> orderOptional = orderRepository.findById(orderId);

            if (orderOptional.isPresent()) {
                Order order = orderOptional.get(); // Obtém o Order do Optional

                Optional<MenuItemOrder> menuItemOrderOptional = menuItemOrderRepository.findById(menuItemOrderId);

                if (menuItemOrderOptional.isPresent()) {
                    MenuItemOrder menuItemOrder = menuItemOrderOptional.get();

                    // Verifica se a lista de menuItemOrders do Order está vazia ou nula
                    if (order.getMenuItemOrders() != null) {
                        menuItemOrder.setOrder(order); // Define a relação bidirecional com o pedido
                        order.getMenuItemOrders().add(menuItemOrder); // Adiciona à lista de MenuItemOrder do pedido
                    } else {
                        List<MenuItemOrder> newMenuItemOrders = new ArrayList<>();
                        menuItemOrder.setOrder(order); // Define a relação bidirecional com o pedido
                        newMenuItemOrders.add(menuItemOrder); // Adiciona à nova lista de MenuItemOrder
                        order.setMenuItemOrders(newMenuItemOrders); // Define a lista no Order
                    }
                } else {
                    // Lógica para lidar com o caso em que o MenuItemOrder não foi encontrado
                }
            } else {
                // Lógica para lidar com o caso em que o Order não foi encontrado
            }
        } else {
            // Lógica para lidar com o caso em que um dos repositórios não foi injetado
        }
    }

    public Optional<Order> findById(UUID id) {
        return orderRepository.findById(id);
    }
}
