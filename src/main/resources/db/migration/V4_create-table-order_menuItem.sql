CREATE TABLE OrderMenuItemOrders (
    order_id UUID,
    menu_item_order_id BIGINT,
    quantity INT,
    FOREIGN KEY (order_id) REFERENCES Order(id),
    FOREIGN KEY (menu_item_order_id) REFERENCES MenuItemOrders(id)
);