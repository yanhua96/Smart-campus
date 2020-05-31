package com.liuhan.smartcampus.dao;

import com.liuhan.smartcampus.entity.Cart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CartMapper {
    Cart getCartById(int goods_id);
    boolean inserCart(Cart cart);
    boolean deleteCart(int id);
    boolean deleteCartAll();
}
