package com.xiaomi.mishop.entity;

import com.xiaomi.mishop.persistence.BaseEntity;
import com.xiaomi.mishop.utils.PattenUtil;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

@Data
public class User extends BaseEntity {
    @Pattern(regexp = PattenUtil.EMAIL_PATTEN, message = "�����ַ��ʽ���Ϸ�")
    private String email;
    @Length(max = 10, min = 3, message = "�û���������3-10֮��")
    private String userName;//�ǳ�
    @Length(max = 10, min = 3, message = "��ʵ����������3-10֮��")
    private String truename;//��ʵ����
    @Length(max = 20, min = 6, message = "���������3-20֮��")
    private String password;
    @Null(message = "����Ϊ��")
    private String sex;
    @Pattern(regexp = PattenUtil.PHONE_PATTEN, message = "�绰�����ʽ���Ϸ�")
    private String phone;
    @Null(message = "����Ϊ��")
    private String address;
    @Null(message = "����Ϊ��")
    private String hobby;//����
    @Null(message = "����Ϊ��")
    private String signature;//����ǩ��
    private int lockstate;//�û��Ƿ����� 1��������0��δ����

}
