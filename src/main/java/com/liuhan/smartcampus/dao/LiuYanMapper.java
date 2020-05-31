package com.liuhan.smartcampus.dao;

import com.liuhan.smartcampus.entity.LiuYan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface LiuYanMapper {
    List<LiuYan> getLiuYan();
    boolean insertLiuYan(LiuYan liuyan);
    LiuYan getLiuYanById(int liuyan_id);
}
