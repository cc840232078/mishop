package com.xiaomi.mishop.entity;

import com.xiaomi.mishop.persistence.BaseEntity;
import lombok.Data;

@Data
public class GoodsCar extends BaseEntity {
    private User userId;//�û�id
    private Integer num;//��Ʒ������
    private GoodsVersion goodsVersion;//�����������Ʒ��
}
