package com.xiaomi.mishop.entity;

import com.xiaomi.mishop.persistence.BaseEntity;
import lombok.Data;

@Data
public class Address extends BaseEntity {
    private String shouhuoren;//�ջ���
    private String phone;//�ջ��˵绰
    private String address;//�ջ��˵�ַ
    private String isDefault;//�Ƿ���Ĭ�ϵ�ַ
    private User user;//���ջ���ַ�����Ǹ��û�
}
