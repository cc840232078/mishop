package com.xiaomi.mishop.entity;

import com.xiaomi.mishop.persistence.BaseEntity;
import lombok.Data;

import javax.validation.constraints.Null;

@Data
public class GoodsType extends BaseEntity {
    @Null(message = "����Ϊ��")
    private String gtypeName;//��Ʒ����
    @Null(message = "����Ϊ��")
    private String gtypePic;//��ƷͼƬ

    private GoodsType goodsType;//�������Ϣ
}
