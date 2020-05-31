package com.liuhan.smartcampus.controller;
import com.liuhan.smartcampus.entity.Cart;
import com.liuhan.smartcampus.entity.Order;
import com.liuhan.smartcampus.entity.OrderItem;
import com.liuhan.smartcampus.service.CartService;
import com.liuhan.smartcampus.service.OrderItemService;
import com.liuhan.smartcampus.service.OrderService;
import com.liuhan.smartcampus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单
 */
@Controller
public class OrderController {
    @Autowired
    OrderService os;
    @Autowired
    OrderItemService ois;
    @Autowired
    CartService cs;
    //根据购物车里面的内容生成订单信息
    @ResponseBody
    @RequestMapping("/inserOrder")
    public boolean getOrder(HttpSession session, Order order,OrderItem orderItem){
        /**
         * 1.获取当前系统时间
         * 2.根据时间和用户id生成订单编号
         * 3.将session中购物车的值取出来   登录用户的id
         * 4.订单状态改为默认1
         * 5.order表的值都有order_songhuodizhi、order_fukuanfangshi  登录用户的id
         * 6.orderitem表主要值有 购物车中的 goods_id goods_quantity
         * 7.执行插入语句
         * 8.清空购物车
         *
         */
        System.out.println("进入成功");
        Date date = StringUtils.getDate();
        List<Cart> carts = (List<Cart>) session.getAttribute("carts");
        int user_id = (int) session.getAttribute("user_id");
        String s = StringUtils.DateToString(date);
        System.out.println(s);
        order.setOrder_bianhao(s+user_id);
        order.setOrder_date(date);
        order.setOrder_zhuangtai(1);
        order.setOrder_user_id(user_id);
/*        order.setOrder_fukuanfangshi(address);
        order.setOrder_fukuanfangshi(payment);*/
//插入order表
        os.insertOrder(order);
        List<OrderItem> lists=new ArrayList<OrderItem>();
        int i=0;
        for (Cart c:carts) {
            orderItem.setOrderItem_id((c.getGoods_id()+s+i));i++;
            orderItem.setGoods_id(c.getGoods_id());
            orderItem.setGoods_quantity(c.getGoods_num());
            orderItem.setOrder_bianhao(s+user_id);
            //插入语句
            ois.insertOrderItem(orderItem);
        }
        //清空购物车
        cs.deleteCartAll(session);
        return true;

    }
    //订单删除功能
    @RequestMapping("/deleteOrder")
    public  String delOrder(@RequestParam("order_id")String id){
        System.out.println("id");
        return "";
    }
    //查看详细订单
    @RequestMapping("/getOrderItemByUserId")
    public String getOrderItemById(HttpSession session, Model model){
        int user_id = (int) session.getAttribute("user_id");
        List<Order> orderByUserId = os.getOrderByUserId(user_id);
        session.removeAttribute("carts");
        model.addAttribute("orderByUserId",orderByUserId);
        return "buyer/cart";
    }
}
