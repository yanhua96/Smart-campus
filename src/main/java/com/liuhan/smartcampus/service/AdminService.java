package com.liuhan.smartcampus.service;

import com.liuhan.smartcampus.entity.Admin;

public interface AdminService {
    Admin getAdmin(Admin admin);
    boolean upAdmin(Admin admin);
}
