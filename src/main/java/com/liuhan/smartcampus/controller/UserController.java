package com.liuhan.smartcampus.controller;

import com.liuhan.smartcampus.entity.Catelog;
import com.liuhan.smartcampus.entity.Goods;
import com.liuhan.smartcampus.entity.User;
import com.liuhan.smartcampus.service.CatelogService;
import com.liuhan.smartcampus.service.GoodsService;
import com.liuhan.smartcampus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户
 */
@Controller
public class UserController {
    @Autowired
    UserService us;
    @Autowired
    CatelogService cs;
    @Autowired
    GoodsService gs;
    @RequestMapping({"/index","/"})
    public String inIndex(HttpSession session,Model model){
        if(null!=session.getAttribute("name")){
            List<Catelog> catelogs = cs.getCatelog();
            List<Goods> goods = gs.getGoods();
            model.addAttribute("catelogs",catelogs);
            model.addAttribute("goods",goods);
            return "/index";
        }else{
            return "common/login";
        }
    }
    @RequestMapping("/userlogin")
    public String getUserByIdAndPw(User user, Model model, HttpSession session){
        User user1 = us.getUserByIdAndPw(user);
        if(user1!=null){
            session.setAttribute("name",user1.getUser_name());
            session.setAttribute("user_id",user1.getUser_id());
            List<Catelog> catelogs = cs.getCatelog();
            List<Goods> goods = gs.getGoods();
            model.addAttribute("catelogs",catelogs);
            model.addAttribute("goods",goods);
            return "index";
        }else{
            model.addAttribute("mes","用户名或者密码错误");
            return "common/login";
        }
    }
    @RequestMapping("/reg")
    public String insertUser(User user,Model model) {
        System.out.println(user.getUser_id());
        Integer X=user.getUser_id();
        User userById = us.getUserById(X);
        User userByName = us.getUserByName(user.getUser_name());
        if (userById == null) {
            if(userByName==null){
                us.insertUser(user);
                return "common/login";
            }else{
                model.addAttribute("nameMes", "该昵称已被使用");
                return "common/registerUser";
            }
        } else {
            model.addAttribute("mes", "该账号已被注册");
            return "common/registerUser";
        }
    }
    //注销登录
    @RequestMapping("/cancellation")
    public String Cancellation(HttpSession session,Model model){
        System.out.println("注销成功");
        session.invalidate();
        List<Catelog> catelogs = cs.getCatelog();
        List<Goods> goods = gs.getGoods();
        model.addAttribute("catelogs",catelogs);
        model.addAttribute("goods",goods);
        return "index";
    }
    @GetMapping("/user/{user_id}")
    public void getUserById(@PathVariable Integer user_id){
        User userById = us.getUserById(user_id);
        System.out.println(userById);
    }
}
