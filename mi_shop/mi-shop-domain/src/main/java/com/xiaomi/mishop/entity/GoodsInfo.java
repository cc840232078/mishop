package com.xiaomi.mishop.entity;

import com.xiaomi.mishop.persistence.BaseEntity;
import lombok.Data;

@Data
public class GoodsInfo extends BaseEntity {
    private String goodsName;//��Ʒ����
    private String goodsDescription;//��Ʒ����
    private String goodsPic;//��Ʒ��Ƭ
    private GoodsType goodsTypeFather;//�����������id������id
}
