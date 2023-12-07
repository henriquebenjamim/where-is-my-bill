CREATE TABLE MenuItemOrders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    item_id BIGINT,
    order_id UUID,
    quantity INT,
    FOREIGN KEY (item_id) REFERENCES Items(id),
    FOREIGN KEY (order_id) REFERENCES Orders(id)
);

