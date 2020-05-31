package com.liuhan.smartcampus.service.impl;

import com.liuhan.smartcampus.dao.LiuYanMapper;
import com.liuhan.smartcampus.entity.LiuYan;
import com.liuhan.smartcampus.service.LiuYanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiuYanServiceImpl implements LiuYanService {
    @Autowired
    LiuYanMapper lm;

    @Override
    public List<LiuYan> getLiuYan() {
        List<LiuYan> liuYans = lm.getLiuYan();
        return liuYans;
    }

    @Override
    public boolean insertLiuYan(LiuYan liuyan) {
        boolean b = lm.insertLiuYan(liuyan);
        return b;
    }

    @Override
    public LiuYan getLiuYanById(int liuyan_id) {
        LiuYan liuYanById = lm.getLiuYanById(liuyan_id);
        return liuYanById;
    }
}
