package com.liuhan.smartcampus;

import com.alibaba.fastjson.JSON;
import com.liuhan.smartcampus.dao.UserMapper;
import com.liuhan.smartcampus.entity.User;
import com.liuhan.smartcampus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
/*import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;*/

@SpringBootTest
class SmartcampusApplicationTests {
/*    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    UserService userService;
    @Autowired
    RedisTemplate<Object,Object> myRedisTemplate;*/
    @Autowired
    RedisTemplate<String,String> redisTemplate;
    @Autowired
    UserMapper userMapper;

    /**
     *redis常见的五大基本数据类型
     * String(字符串)、list(列表)、Set(集合)、Hash(散列)、ZSet(有序集合)
     */
    @Test
    public void test01(){
/*        stringRedisTemplate.opsForValue().append("mes","hellow");*/
        User user=new User();
        user.setUser_id(111);
        user.setUser_pw("1");
        User users = userMapper.getUserByIdAndPw(user);
        System.out.println(users);
    }
    @Test
    public void test02(){
        User user = new User();
        user.setUser_id(12);
        user.setUser_pw("12334");
        redisTemplate.opsForValue().set("le", JSON.toJSONString(user));
    }

    @Test
    void contextLoads() {
        User user = userMapper.selectById(111);
        System.out.println(user);
    }

}
