package com.xiaomi.mishop;

import com.xiaomi.mishop.entity.Address;
import com.xiaomi.mishop.entity.GoodsCar;
import com.xiaomi.mishop.entity.GoodsVersion;
import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.service.GoodsCarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class test {
    @Autowired
    private GoodsCarService goodsCarService;

    @Test
    public void test() {

        User user = new User();
        user.setId(1l);
        //List<GoodsVersion> goodsVersion = goodsCarService.getGoodsVersion(user);
        List<Address> goodsCar = goodsCarService.getAddress(user);
        System.out.println(goodsCar);
       /* GoodsCar goodsCar1 = new GoodsCar();
        goodsCar1.getGoodsVersion().getGoodsInfo().getGoodsPic();*/
    }
}
