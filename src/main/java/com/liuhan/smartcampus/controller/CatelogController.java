package com.liuhan.smartcampus.controller;

import com.liuhan.smartcampus.dao.CatelogMapper;
import com.liuhan.smartcampus.entity.Catelog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 菜单
 */
@Controller
public class CatelogController {
    @Autowired
    CatelogMapper cm;
    //获取到所有菜品的内容
    @ResponseBody
    @RequestMapping("/getCatelog")
    public Model getCatelogAll(Model model){
        List<Catelog> catelogs = cm.getCatelog();
        model.addAttribute("list",catelogs);
        return model;
    }
    //删除功能
    @ResponseBody
    @RequestMapping("/delCatelog")
    public Model delcart(@RequestParam("catelog_id")int id,Model model){
        boolean b = cm.delCatelog(id);
        List<Catelog> catelogs = cm.getCatelog();
        model.addAttribute("list",catelogs);
        return model;
    }
}
