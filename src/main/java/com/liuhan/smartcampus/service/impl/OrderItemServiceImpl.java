package com.liuhan.smartcampus.service.impl;

import com.liuhan.smartcampus.dao.OrderItemMapper;
import com.liuhan.smartcampus.entity.Details;
import com.liuhan.smartcampus.entity.OrderItem;
import com.liuhan.smartcampus.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemMapper oim;
    @Override
    public List<OrderItem> getOrderItemBy(String orderitem_id) {
        List<OrderItem> orderItemBy = oim.getOrderItemBy(orderitem_id);
        return orderItemBy;
    }

    @Override
    public List<Details> getDetails(int order_id) {
        List<Details> details = oim.getDetails(order_id);
        return details;
    }

    @Override
    public boolean insertOrderItem(OrderItem orderItem) {

        System.out.println(orderItem);
        boolean b = oim.insertOrderItem(orderItem);

        return b;
    }
}
