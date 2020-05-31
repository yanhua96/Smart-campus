package com.liuhan.smartcampus.service;

import com.liuhan.smartcampus.entity.Cart;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface CartService {
    List<Cart> getCart(HttpSession session);
    Cart getCartById(int goods_id);
    List<Cart> inserCart(Cart cart,HttpSession session,int id);
    List<Cart>  deleteCart(int id,HttpSession session);
    boolean deleteCartAll(HttpSession session);
}
