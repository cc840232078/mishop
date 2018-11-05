package com.xiaomi.mishop.entity;

import com.xiaomi.mishop.persistence.BaseEntity;
import lombok.Data;

import javax.validation.constraints.Null;

@Data
public class GoodsType extends BaseEntity {
    @Null(message = "不能为空")
    private String gtypeName;//商品名称
    @Null(message = "不能为空")
    private String gtypePic;//商品图片

    private GoodsType goodsType;//父类的信息
}
