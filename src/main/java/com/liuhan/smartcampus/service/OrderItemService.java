package com.liuhan.smartcampus.service;

import com.liuhan.smartcampus.entity.Details;
import com.liuhan.smartcampus.entity.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> getOrderItemBy(String orderitem_id);
    List<Details> getDetails(int order_id);
    boolean insertOrderItem(OrderItem orderItem);
}
