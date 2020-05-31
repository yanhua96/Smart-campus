package com.liuhan.smartcampus.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
@Data
public class User  extends Model<User> {
    @TableId
    private Integer user_id;
    private String user_name;
    private String user_pw;
    private String user_realname;
    private String user_sex;
    private int user_age;
    private String user_address;
    private String user_tel;
    private String user_email;
}
