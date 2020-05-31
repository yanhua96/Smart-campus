package com.liuhan.smartcampus.dao;

import com.liuhan.smartcampus.entity.Details;
import com.liuhan.smartcampus.entity.OrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderItemMapper {
    List<OrderItem> getOrderItemBy(String orderitem_id);
    List<Details> getDetails(int order_id);
    boolean insertOrderItem(OrderItem orderItem);

}
