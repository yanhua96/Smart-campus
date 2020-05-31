package com.liuhan.smartcampus.service;

import com.liuhan.smartcampus.entity.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> getGoods();
    List<Goods> getGoodsByName(String name);
    List<Goods> getGoodsByCatelog(String catelog);
    Goods getGoodsById(int goods_id);
    boolean insertGoods(Goods goods);
    boolean delGoods(int good_id);
}
