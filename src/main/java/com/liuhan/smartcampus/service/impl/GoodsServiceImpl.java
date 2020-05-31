package com.liuhan.smartcampus.service.impl;

import com.liuhan.smartcampus.dao.GoodsMapper;
import com.liuhan.smartcampus.entity.Goods;
import com.liuhan.smartcampus.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper gm;
    @Override
    public List<Goods> getGoods() {
        List<Goods> goods = gm.getGoods();
        return goods;
    }

    @Override
    public List<Goods> getGoodsByName(String name) {
        List<Goods> goodsByName = gm.getGoodsByName(name);
        return goodsByName;
    }

    @Override
    public List<Goods> getGoodsByCatelog(String catelog) {
        List<Goods> goodsByCatelog = gm.getGoodsByCatelog(catelog);
        return goodsByCatelog;
    }

    @Override
    public Goods getGoodsById(int goods_id) {
        Goods goodsById = gm.getGoodsById(goods_id);
        return goodsById;
    }

    @Override
    public boolean insertGoods(Goods goods) {
        boolean b = gm.insertGoods(goods);
        return b;
    }

    @Override
    public boolean delGoods(int good_id) {
        boolean b = gm.delGoods(good_id);
        return b;
    }
}
