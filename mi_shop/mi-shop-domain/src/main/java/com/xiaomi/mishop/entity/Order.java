package com.xiaomi.mishop.entity;

import com.xiaomi.mishop.persistence.BaseEntity;
import lombok.Data;

import java.util.Date;

@Data
public class Order extends BaseEntity {
    //注意 这里的id表示的是订单号  用的是第二阶段项目的 id 生成法
    private String oSendtype;//用的是那一个快递公司  有了 前台传
    private String oPaytype;//支付方式  有了  前台传
    private double oPaycount;//订单总价   无  前台传
    private Date oCreadedate;//订单生成的时间  无  后台生成
    private User userId;//表示是那个用户生成的订单  有  session里面生成
    private String oShperson;//收货人  有  前台传
    private String oShphone;//收货人电话  有  前台传
    private String oShaddress;//收货人地址  有  前台传
    private String oStarve;//订单状态  无  后台生成默认值是支付成功
}
