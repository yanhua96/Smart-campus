package com.liuhan.smartcampus.controller;

import com.liuhan.smartcampus.entity.Cart;
import com.liuhan.smartcampus.entity.Catelog;
import com.liuhan.smartcampus.entity.Goods;
import com.liuhan.smartcampus.service.CartService;
import com.liuhan.smartcampus.service.CatelogService;
import com.liuhan.smartcampus.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    CartService cs;
    @Autowired
    GoodsService gs;
    @Autowired
    CatelogService cls;
    //获取session中所有的购物车内容

    /**
     * 从数据库中获取购物车数据
     * @param
     * @return
     */
    @RequestMapping("/getCart")
    public String getCart(HttpSession session,Model model){
        //初始化购物车
        List<Cart> cart = cs.getCart(session);
        System.out.println(cart);
        return "buyer/cart";
    }
    //删除session中一条数据

    /**
     * 通过id删除购物车的数据
     * @param id 商品id
     * @return
     */
    @RequestMapping("/deleteCart")
    public String delCart(@RequestParam("id")int id,HttpSession session){
        String name = (String) session.getAttribute("name");
        String result="0";
        if(null!=name){
            List<Cart> carts = cs.deleteCart(id, session);
            if(carts.size()!=0){
                session.setAttribute("carts",carts);
            }else{
                session.removeAttribute("carts");
            }
            result="1";
        }
        return "redirect:/buyer/cart.html";
    }
    /**
     * 加入购物车
     *
     */
    @ResponseBody
    @RequestMapping("/setCart")
    public List<Cart> setCart(Cart cart,HttpSession session,@RequestParam("id")int id){
        cart.setGoods_num(1);
        List<Cart> carts = cs.inserCart(cart, session,id);
        session.setAttribute("carts",carts);
        return carts;
    }
    //清空购物车
    @RequestMapping("/emptyCart")
    public String emptyCart(HttpSession session){
        cs.deleteCartAll(session);
        return "buyer/cart";
    }
}
