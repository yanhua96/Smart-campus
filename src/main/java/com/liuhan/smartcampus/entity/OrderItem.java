package com.liuhan.smartcampus.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class OrderItem {
    @TableId
    private String orderItem_id;
    private String order_bianhao;
    private int goods_id;
    private int goods_quantity;
}
