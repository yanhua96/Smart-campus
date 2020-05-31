package com.liuhan.smartcampus.dao;

import com.liuhan.smartcampus.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface GoodsMapper {
    List<Goods> getGoods();
    List<Goods> getGoodsByName(String name);
    List<Goods> getGoodsByCatelog(String catelog);
    Goods getGoodsById(int goods_id);
    boolean insertGoods(Goods goods);
    boolean delGoods(int good_id);
}
