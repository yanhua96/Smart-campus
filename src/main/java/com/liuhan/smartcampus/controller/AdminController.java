package com.liuhan.smartcampus.controller;

import com.liuhan.smartcampus.dao.CatelogMapper;
import com.liuhan.smartcampus.dao.UserMapper;
import com.liuhan.smartcampus.entity.*;
import com.liuhan.smartcampus.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    AdminService as;
    @Autowired
    UserService us;
    @Autowired
    CatelogService cs;
    @Autowired
    GoodsService gs;
    @Autowired
    OrderService os;
    @Autowired
    OrderItemService ois;
    @Autowired
    UserMapper um;
    @Autowired
    CatelogMapper  cm;
    //管理员密码修改

    //管理员登录功能
    @RequestMapping("/adminLogin")
    public String getAdmin(Admin admin, HttpSession session, Model model){
        Admin admin1 = as.getAdmin(admin);
        System.out.println(admin1);
        if(admin1!=null){
            session.setAttribute("adname",admin1.getUser_name());
            return "admin/adminindex";
        }else{
            model.addAttribute("mes","用户名或者密码错误");
            return "admin/adminlogin";
        }

    }
    //修改密码
    @RequestMapping("/upAdmin")
    public String upAdmin(Admin admin,Model model,HttpSession session,@RequestParam("user_pw")String user_pw){
        String adminname = (String) session.getAttribute("adminname");
        if( null!=adminname){
            admin.setUser_name((String) session.getAttribute("adname"));
            admin.setUser_pw(user_pw);
            boolean b = as.upAdmin(admin);
            model.addAttribute("mes","修改成功");
            model.addAttribute("pw",b);
            model.addAttribute("lettbar",1);
            return "admin/adminindex";
        }else {
            return "admin/adminlogin";
        }

    }
    //管理员推出
    @RequestMapping("/admincancellation")
    public String Cancellation(HttpSession session){session.invalidate(); return "redirect:/index";}
    //用户管理模块
    //查看所有用户

    //删除点击用户
    @RequestMapping("/deleteUser")
    public String delUser(@RequestParam("id")int user_id,Model model,HttpSession session){
        String adminname = (String) session.getAttribute("adname");
        if( null!=adminname){
            us.delUser(user_id);
            model.addAttribute("lettbar",2);
            List<User> user = um.getUser();
            model.addAttribute("users",user);
            return "admin/adminindex";
        }else {
            return "admin/adminlogin";
        }

    }

    //菜品类别管理模块
    //菜品类别展示
    //菜品类别添加
    @RequestMapping("/insertCatelog")
    public String insertCatelog(Model model,Catelog catelog,@RequestParam("id")String catelog_name,HttpSession session){
        String adminname = (String) session.getAttribute("adname");
        if( null!=adminname){
            catelog.setCatelog_name(catelog_name);
            cs.insertCatelog(catelog);
            return "admin/adminindex";
        }else {
            return "admin/adminlogin";
        }

    }
    //菜品类别删除
    @RequestMapping("/delectCatelog")
    public String delCatelog(Model model,@RequestParam("id")int id ,HttpSession session){
        String adminname = (String) session.getAttribute("adname");
        if( null!=adminname){
            boolean b = cs.delCatelog(id);
            model.addAttribute("lettbar",3);
            List<Catelog> catelog = cs.getCatelog();
            model.addAttribute("catelogs",catelog);
            return "admin/adminindex";
        }else {
            return "admin/adminlogin";
        }

    }

    //菜品管理模块

    //所有菜品展示
    //菜品添加
    @ResponseBody
    @RequestMapping("/insertGoods")
    public String insertGoods(Goods goods,Model model){
        /**
         * 根据菜品种类获取菜品id
         * 插入语句
         */
        String error="";
        Catelog catelogByName = cm.getCatelogByName(goods.getGoods_type());
        if(null!=catelogByName){
            goods.setGoods_catelog_id(catelogByName.getCatelog_id());
            boolean b = gs.insertGoods(goods);
            //查找该类
            List<Goods> goodss = gs.getGoods();
            model.addAttribute("goods",goodss);
            model.addAttribute("lettbar",4);
        }else{
            error="请先添加该菜类";
        }
        return error;
    }
    //菜品删除

    @RequestMapping("/deleteGoods")
    public String delGoods(@RequestParam("id")int goods_id,Model model,HttpSession session){
        String adminname = (String) session.getAttribute("adname");
        if( null!=adminname){
            boolean b = gs.delGoods(goods_id);
            List<Goods> goods = gs.getGoods();
            model.addAttribute("goods",goods);
            model.addAttribute("lettbar",4);
            return "admin/adminindex";
        }else {
            return "admin/adminlogin";
        }

    }

    //订单管理模块
    //查询所有订单
    //订单受理
    @RequestMapping("/upOrder")
    public String upOrder(@RequestParam("id")int id,Order order,Model model,HttpSession session){

        String adminname = (String) session.getAttribute("adname");
        if( null!=adminname){
            order.setOrder_id(id);
            order.setOrder_zhuangtai(2);
            boolean b = os.updateOrder(order);
            List<Order> orders = os.selectOrder();
            model.addAttribute("orders",orders);
            model.addAttribute("lettbar",5);
            return "admin/adminindex";
        }else {
            return "admin/adminlogin";
        }



    }
    //订单删除
    @RequestMapping("/delOrderById")
    public String delOrder(@RequestParam("id")int id,Model model,HttpSession session){



        String adminname = (String) session.getAttribute("adname");
        if( null!=adminname){
            boolean b = os.delOrderById(id);
            List<Order> orders = os.selectOrder();
            model.addAttribute("orders",orders);
            model.addAttribute("lettbar",5);
            return "admin/adminindex";
        }else {
            return "admin/adminlogin";
        }


    }
    //订单明细
    /**
     * 使用表多表链接查询出明细表的数量和名称  再加上订单表的价格
     */

}
