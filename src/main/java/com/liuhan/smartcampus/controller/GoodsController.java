package com.liuhan.smartcampus.controller;

import com.liuhan.smartcampus.entity.Catelog;
import com.liuhan.smartcampus.entity.Goods;
import com.liuhan.smartcampus.service.CatelogService;
import com.liuhan.smartcampus.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 商品总览
 */
@Controller
public class GoodsController {
    @Autowired
    GoodsService gs;
    @Autowired
    CatelogService cs;

    /**
     *根据点击菜的种类查询菜的信息
     * @param catelog 菜品类型
     * @param model
     * @return 返回查询数据
     */
    @RequestMapping("/selectCatelog")
    public String selectCatelog(@RequestParam("catelog")String catelog,Model model){
        List<Goods> goodsByCatelog = gs.getGoodsByCatelog(catelog);
        model.addAttribute("goods",goodsByCatelog);
        return "index";
    }

    /**
     * 菜品模糊查询
     * @param name 获取到前台输入框的值
     * @param model
     * @return
     */
    @RequestMapping("/getGoodsByName")
    public String getGoodsByName(@RequestParam("goods_name")String name,Model model){
        System.out.println(name);

        List<Goods> goodsByName = gs.getGoodsByName(name);
        model.addAttribute("goods",goodsByName);
        List<Catelog> catelog = cs.getCatelog();
        model.addAttribute("catelogs",catelog);
        return "index";
    }

}
