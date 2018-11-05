package com.xiaomi.mishop.entity;

import com.xiaomi.mishop.persistence.BaseEntity;
import lombok.Data;

@Data
public class GoodsInfo extends BaseEntity {
    private String goodsName;//商品名字
    private String goodsDescription;//商品描述
    private String goodsPic;//商品照片
    private GoodsType goodsTypeFather;//用这个包含父id和祖宗id
}
