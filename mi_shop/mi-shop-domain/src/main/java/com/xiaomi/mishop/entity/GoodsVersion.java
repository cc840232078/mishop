package com.xiaomi.mishop.entity;

import com.xiaomi.mishop.persistence.BaseEntity;
import lombok.Data;

/**
 * �����Ӧ�������ݿ��е�t_goods_version��
 * ����GoodsInfo������goods_info_id�ֶ�
 */
@Data
public class GoodsVersion extends BaseEntity {
    private double goodsPrice;//��Ʒ�۸�
    private int goodsStock;//���
    private String version;//��Ʒ�汾
    private GoodsInfo goodsInfo;//�����Ǹ���Ʒ
}
