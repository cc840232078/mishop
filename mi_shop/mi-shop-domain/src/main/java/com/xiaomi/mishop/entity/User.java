package com.xiaomi.mishop.entity;

import com.xiaomi.mishop.persistence.BaseEntity;
import com.xiaomi.mishop.utils.PattenUtil;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

@Data
public class User extends BaseEntity {
    @Pattern(regexp = PattenUtil.EMAIL_PATTEN, message = "邮箱地址格式不合法")
    private String email;
    @Length(max = 10, min = 3, message = "用户名必须在3-10之内")
    private String userName;//昵称
    @Length(max = 10, min = 3, message = "真实姓名必须在3-10之内")
    private String truename;//真实姓名
    @Length(max = 20, min = 6, message = "密码必须在3-20之内")
    private String password;
    @Null(message = "不能为空")
    private String sex;
    @Pattern(regexp = PattenUtil.PHONE_PATTEN, message = "电话号码格式不合法")
    private String phone;
    @Null(message = "不能为空")
    private String address;
    @Null(message = "不能为空")
    private String hobby;//爱好
    @Null(message = "不能为空")
    private String signature;//个性签名
    private int lockstate;//用户是否被锁定 1：锁定，0：未锁定

}
