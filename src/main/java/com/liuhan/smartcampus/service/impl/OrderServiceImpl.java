package com.liuhan.smartcampus.service.impl;

import com.liuhan.smartcampus.dao.OrderMapper;
import com.liuhan.smartcampus.entity.Order;
import com.liuhan.smartcampus.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper om;
    @Override
    public boolean delOrder(int order_id) {
        boolean b = om.delOrder(order_id);
        return b;
    }

    @Override
    public boolean insertOrder(Order order) {
        boolean b = om.insertOrder(order);
        return b;
    }

    @Override
    public boolean updateOrder(Order order) {
        boolean b = om.updateOrder(order);
        return b;
    }

    @Override
    public List<Order> getOrderByUserId(int order_user_id) {
        List<Order> orderByUserId = om.getOrderByUserId(order_user_id);
        return orderByUserId;
    }

    @Override
    public List<Order> selectOrder() {
        List<Order> orders = om.selectOrder();
        return orders;
    }

    @Override
    public boolean delOrderById(int order_id) {
        boolean b = om.delOrderById(order_id);
        return b;
    }
}
