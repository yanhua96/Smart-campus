package com.liuhan.smartcampus.dao;

import com.liuhan.smartcampus.entity.Catelog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CatelogMapper {
    boolean delCatelog(int catelog_id);
    List<Catelog> getCatelog();
    boolean insertCatelog(Catelog catelog);
    Catelog getCatelogByName(String catelog_name);
}
