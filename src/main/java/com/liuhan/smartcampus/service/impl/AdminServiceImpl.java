package com.liuhan.smartcampus.service.impl;

import com.liuhan.smartcampus.dao.AdminMapper;
import com.liuhan.smartcampus.entity.Admin;
import com.liuhan.smartcampus.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper am;
    @Override
    public Admin getAdmin(Admin admin) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("admin",admin);
        Admin admin1 = (Admin) am.selectByMap(map);
        System.out.println(admin1);
        return admin1;
    }

    @Override
    public boolean upAdmin(Admin admin) {
        return false;
    }

}
