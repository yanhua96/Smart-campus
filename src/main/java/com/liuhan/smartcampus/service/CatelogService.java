package com.liuhan.smartcampus.service;

import com.liuhan.smartcampus.entity.Catelog;

import java.util.List;

public interface CatelogService {
    boolean delCatelog(int catelog_id);
    List<Catelog> getCatelog();
    boolean insertCatelog(Catelog catelog);
}
