package com.liuhan.smartcampus.service;

import com.liuhan.smartcampus.entity.User;

import java.util.List;

public interface UserService {
    User getUserByName(String name);
    void insertUser(User user);
    User getUserByIdAndPw(User user);
    User getUserById(Integer id);
    List<User> getUser();
    boolean delUser(int user_id);
}
