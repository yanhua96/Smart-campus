package com.liuhan.smartcampus.controller;

import com.liuhan.smartcampus.entity.LiuYan;
import com.liuhan.smartcampus.service.LiuYanService;
import com.liuhan.smartcampus.service.OrderService;
import com.liuhan.smartcampus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 留言区
 */
@Controller
public class LiuYanController {
    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    Date date = new Date(System.currentTimeMillis());
    @Autowired
    LiuYanService ls;
    //查询出所有信息
    @RequestMapping("/getLiuYan")
    public String getLiuYan(Model model){
        List<LiuYan> liuYan = ls.getLiuYan();
        model.addAttribute("liuyans",liuYan);
        return "";
    }
    //获取到前台用户输入的信息并插入到留言表中
    @RequestMapping("/insertLiuYan")
    public String insertLiuYan(LiuYan liuyan, HttpSession session){
        liuyan.setLiuyan_user((String)session.getAttribute("name"));
        liuyan.setLiuyan_date(date);
        int x=StringUtils.generateRandomByScope(1000,999999);
        if(ls.getLiuYanById(x)==null){
            liuyan.setLiuyan_id(x);
        }else{
            x=StringUtils.generateRandomByScope(1000,999999);
        }
        ls.insertLiuYan(liuyan);
        return "liuyan";
    }
}
