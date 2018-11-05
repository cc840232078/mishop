package com.xiaomi.mishop.entity;

import com.xiaomi.mishop.persistence.BaseEntity;
import lombok.Data;

/**
 * 该类对应的是数据库中的t_goods_version表
 * 其中GoodsInfo来代替goods_info_id字段
 */
@Data
public class GoodsVersion extends BaseEntity {
    private double goodsPrice;//商品价格
    private int goodsStock;//库存
    private String version;//商品版本
    private GoodsInfo goodsInfo;//属于那个商品
}
