package com.liuhan.smartcampus.dao;

import com.liuhan.smartcampus.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    boolean delOrder(int order_id);
    boolean updateOrder(Order order);
    List<Order> getOrderByUserId(int order_user_id);
    List<Order> selectOrder();
    boolean delOrderById(int order_id);
    boolean insertOrder(Order order);
}
