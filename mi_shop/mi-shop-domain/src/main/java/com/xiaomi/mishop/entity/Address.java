package com.xiaomi.mishop.entity;

import com.xiaomi.mishop.persistence.BaseEntity;
import lombok.Data;

@Data
public class Address extends BaseEntity {
    private String shouhuoren;//收货人
    private String phone;//收货人电话
    private String address;//收货人地址
    private String isDefault;//是否是默认地址
    private User user;//该收货地址属于那个用户
}
