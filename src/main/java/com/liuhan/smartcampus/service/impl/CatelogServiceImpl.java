package com.liuhan.smartcampus.service.impl;

import com.liuhan.smartcampus.dao.CatelogMapper;
import com.liuhan.smartcampus.entity.Catelog;
import com.liuhan.smartcampus.service.CatelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatelogServiceImpl implements CatelogService {
    @Autowired
    CatelogMapper cm;
    @Override
    public boolean delCatelog(int id) {
        boolean b = cm.delCatelog(id);
        return b;
    }

    @Override
    public List<Catelog> getCatelog() {
        List<Catelog> catelogs = cm.getCatelog();
        return catelogs;
    }

    @Override
    public boolean insertCatelog(Catelog catelog) {
        boolean b = cm.insertCatelog(catelog);
        return b;
    }
}
