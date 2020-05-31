package com.liuhan.smartcampus.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
@Data
public class Order {
    @TableId
    private int order_id;
    private String order_bianhao;
    private Date order_date;
    private int order_zhuangtai;
    private String order_songhuodizhi;
    private String order_fukuanfangshi;
    private int order_user_id;
    private OrderItem orderItem;
}
