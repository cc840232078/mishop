package com.xiaomi.mishop.entity;

import com.xiaomi.mishop.persistence.BaseEntity;
import lombok.Data;

@Data
public class OrderDetail extends BaseEntity {
	private Order order;//这里是属于哪一个订单
    private GoodsVersion goodsVersion;//用这里面的商品名称，商品单价，商品图片
    private int goodsnum;//商品数量
    private double goodsTotalPrice;//商品总价  商品单价*商品数量
}
