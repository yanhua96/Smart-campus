package com.liuhan.smartcampus.service;

import com.liuhan.smartcampus.entity.Order;

import java.util.List;

public interface OrderService {
    boolean delOrder(int order_id);
    boolean insertOrder(Order order);
    boolean updateOrder(Order order);
    List<Order> getOrderByUserId(int order_user_id);
    List<Order> selectOrder();
    boolean delOrderById(int order_id);
}
