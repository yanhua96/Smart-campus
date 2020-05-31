package com.liuhan.smartcampus.controller;

import com.liuhan.smartcampus.entity.Details;
import com.liuhan.smartcampus.entity.OrderItem;
import com.liuhan.smartcampus.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 详细订单
 */
@Controller
public class OrderItemController {
    @Autowired
    OrderItemService orderItemService;
    /*@RequestMapping("/fff")
    public String FFFF(){
        OrderItem orderItem=new OrderItem("11","11",1,1);
         orderItemService.insertOrderItem(orderItem);
     return "";*/
/*}*/
}
