package com.liuhan.smartcampus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuhan.smartcampus.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    User getUserByName(String name);
    void insertUser(User user);
    @Select("select * from t_user where user_id = #{user_id} and user_pw = #{user_pw}")
    User getUserByIdAndPw(User user);
    User getUserById(Integer user_id);
    List<User> getUser();
    boolean delUser(int user_id);
}
