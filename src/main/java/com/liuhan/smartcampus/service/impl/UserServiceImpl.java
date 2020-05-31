package com.liuhan.smartcampus.service.impl;

import com.liuhan.smartcampus.dao.UserMapper;
import com.liuhan.smartcampus.entity.User;
import com.liuhan.smartcampus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper um;

    @Override
    public User getUserByName(String name) {
        User user = um.getUserByName(name);
        return user;
    }

    @Override
    public void insertUser(User user) {
        System.out.println(user);
        um.insertUser(user);
    }

    @Override
    public User getUserByIdAndPw(User user) {
        System.out.println(user.getUser_id());
        Integer id = user.getUser_id();
        User user1 = um.selectById(111);

        System.out.println("获取到用户。。。");
        System.out.println(user);
        User userByIdAndPw = um.getUserByIdAndPw(user);
        System.out.println("获取成功。。。");
        System.out.println(userByIdAndPw);
        return userByIdAndPw;
    }
/*    @Cacheable(cacheNames = "userById",key = "#user_id")*/
    @Override
    public User getUserById(Integer user_id) {
        System.out.println(user_id);
        User userById = um.getUserById(user_id);

        return userById;
    }
    @Override
    public List<User> getUser() {
        List<User> users = um.getUser();
        return users;
    }

    @Override
    public boolean delUser(int user_id) {
        boolean b = um.delUser(user_id);
        return b;
    }

}
