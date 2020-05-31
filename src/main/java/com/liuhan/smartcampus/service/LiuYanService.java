package com.liuhan.smartcampus.service;

import com.liuhan.smartcampus.entity.LiuYan;

import java.util.List;

public interface LiuYanService {
    List<LiuYan> getLiuYan();
    boolean insertLiuYan(LiuYan liuyan);
    LiuYan getLiuYanById(int liuyan_id);
}
