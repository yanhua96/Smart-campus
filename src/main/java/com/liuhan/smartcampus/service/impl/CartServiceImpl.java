package com.liuhan.smartcampus.service.impl;

import com.liuhan.smartcampus.dao.CartMapper;
import com.liuhan.smartcampus.entity.Cart;
import com.liuhan.smartcampus.entity.Goods;
import com.liuhan.smartcampus.service.CartService;
import com.liuhan.smartcampus.service.CatelogService;
import com.liuhan.smartcampus.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartMapper cm;
    @Autowired
    CartService cs;
    @Autowired
    GoodsService gs;
    @Autowired
    CatelogService cls;
    @Override
    public List<Cart> getCart(HttpSession session) {
        List<Cart> cart=null;
        cart= (List<Cart>) session.getAttribute("carts");
        if(cart==null){
            cart=new ArrayList<Cart>();
        }
        return cart;
    }

    @Override
    public Cart getCartById(int goods_id) {
        Cart cartById = cm.getCartById(goods_id);
        return cartById;
    }

    @Override
    public List<Cart> inserCart(Cart cart, HttpSession session,int id) {
        Goods goodsById = gs.getGoodsById(id);
        cart.setGoods_id(goodsById.getGoods_id());
        cart.setGoods_name(goodsById.getGoods_name());
        cart.setGoods_pic(goodsById.getGoods_pic());

        List<Cart> insertcarts = null;
        insertcarts = (List<Cart>) session.getAttribute("carts");
        if (insertcarts == null) {
            insertcarts = new ArrayList<Cart>();
            insertcarts.add(cart);
        } else {
            int pe = 0;
            for (Cart c : insertcarts) {
                if (cart.getGoods_id() == c.getGoods_id()) {
                    int sum = c.getGoods_num();
                    c.setGoods_num(sum + cart.getGoods_num());
                    pe++;
                    System.out.println(c.getGoods_num());
                }

            }
            if (pe == 0) {
                insertcarts.add(cart);
            }
            for (Cart c : insertcarts) {
                if (cart.getGoods_id() == c.getGoods_id()) {
                    int sum = c.getGoods_num();
                    c.setGoods_num(sum + cart.getGoods_num());
                    pe++;
                    System.out.println(c.getGoods_num());
                }

            }


        }
        System.out.println(insertcarts);

        return insertcarts;
    }



    @Override
    public List<Cart> deleteCart(int id,HttpSession session) {
        List<Cart> delCarts=null;
        delCarts=(List<Cart>)session.getAttribute("carts");
            int sum=0;
            if(delCarts.size()==1){
                delCarts.remove(0);
            }else{
                for (Cart c:delCarts) {
                    sum++;

                    if(c.getGoods_id()==id){
                        delCarts.remove(sum-1);
                    }
            }

        }
            System.out.println(delCarts);

        return delCarts;
    }

    @Override
    public boolean deleteCartAll(HttpSession session) {
        List<Cart> delcarts=null;
        delcarts = (List<Cart>) session.getAttribute("carts");
        if(delcarts!=null){
            session.removeAttribute("carts");
        }
        return true;
    }
}
