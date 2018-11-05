package com.xiaomi.mishop.entity;

import com.xiaomi.mishop.persistence.BaseEntity;
import lombok.Data;

@Data
public class GoodsCar extends BaseEntity {
    private User userId;//用户id
    private Integer num;//商品的数量
    private GoodsVersion goodsVersion;//里面包含了商品类
}
