package com.liuhan.smartcampus.controller;

import com.liuhan.smartcampus.dao.UserMapper;
import com.liuhan.smartcampus.entity.*;
import com.liuhan.smartcampus.service.CatelogService;
import com.liuhan.smartcampus.service.GoodsService;
import com.liuhan.smartcampus.service.OrderItemService;
import com.liuhan.smartcampus.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class testController {
    @Autowired
    UserMapper um;
    @Autowired
    GoodsService gs;
    @Autowired
    CatelogService cs;
    @Autowired
    OrderService os;
    @Autowired
    OrderItemService ois;
    @RequestMapping("/login")
    public String inLogin(){return "/common/login";}
    @RequestMapping("/regist")
    public String inReg(){return "/common/registerUser";}
    @RequestMapping("/cart")
    public String inCtttart(){return "/buyer/cart";}
    @RequestMapping("/adlogin")
    public String inAdminLogin(){return "/admin/adminlogin";}
    @RequestMapping("/adminindex")
    public String inAdminindex(){return "/admin/adminindex";}
    @RequestMapping("/shopping_cart")
    public String inShopping_cart(){return "/buyer/shopping_cart";}
    @RequestMapping("/lettbar1")
    public String inAdmin1(Model model){
        model.addAttribute("lettbar",1);
        return "admin/adminindex";
    }
    @RequestMapping("/lettbar2")
    public String inAdmin2(Model model){
        List<User> user = um.getUser();
        model.addAttribute("users",user);
        model.addAttribute("lettbar",2);
        return "admin/adminindex";
    }
    @RequestMapping("/lettbar3")
    public String inAdmin3(Model model){
        List<Catelog> catelog = cs.getCatelog();
        model.addAttribute("catelogs",catelog);
        model.addAttribute("lettbar",3);
        return "admin/adminindex";
    }
    @RequestMapping("/lettbar4")
    public String inAdmin4(Model model){
        List<Goods> goods = gs.getGoods();
        model.addAttribute("goods",goods);
        model.addAttribute("lettbar",4);
        return "admin/adminindex";
    }
    @RequestMapping("/lettbar5")
    public String inAdmin5(Model model){
        List<Order> orders = os.selectOrder();
        model.addAttribute("orders",orders);
        model.addAttribute("lettbar",5);
        return "admin/adminindex";
    }
    @RequestMapping("/lettbar6")
    public String inAdmin6(Model model){

        model.addAttribute("lettbar",6);
        return "admin/adminindex";
    }
    @RequestMapping("/OrderImpl")

    public String getOrderItemById(@RequestParam("id")String orderitem_id, Model model){
        List<GoodsImpl> listgsi=new ArrayList<GoodsImpl>();
        GoodsImpl gsi=new GoodsImpl();
        List<OrderItem> orderItemBy = ois.getOrderItemBy(orderitem_id);
        Map map=null;
        int i=0;
        for (OrderItem o:orderItemBy) {
            map=new HashMap();
            gsi.setNum(o.getGoods_quantity());
            Goods goodsById = gs.getGoodsById(o.getGoods_id());
            gsi.setPic(goodsById.getGoods_pic());
            gsi.setName(goodsById.getGoods_name());
            map.put(i,gsi);
            i++;
            listgsi.add((GoodsImpl) map);
        }

        System.out.println(listgsi);
        model.addAttribute("orderItemBy","listgsi");
        model.addAttribute("lettbar",6);
        return "admin/adminindex";
    }
}

