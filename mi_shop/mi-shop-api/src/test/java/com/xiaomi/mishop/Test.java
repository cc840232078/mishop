package com.xiaomi.mishop;

import com.xiaomi.mishop.dao.GoodsCarDao;
import com.xiaomi.mishop.entity.Address;
import com.xiaomi.mishop.entity.GoodsCar;
import com.xiaomi.mishop.entity.GoodsVersion;
import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.service.ApiLoginService;
import com.xiaomi.mishop.service.GoodsCarService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class Test {

    @Autowired
    private GoodsCarDao goodsCarDao;

    @Autowired
    private GoodsCarService goodsCarService;

    @Autowired
    private ApiLoginService apiLoginService;

    @org.junit.Test
    public void test() {

        User login = apiLoginService.login("cyc", "e10adc3949ba59abbe56e057f20f883e");
        System.out.println(login);
        /*List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        List<GoodsVersion> goodsVersion = goodsCarDao.getGoodsVersion(list);
        GoodsVersion goodsVersion1 = goodsVersion.get(0);
        System.out.println(goodsVersion1.getId());
        System.out.println(goodsVersion1.getGoodsInfo().getId());
        System.out.println(goodsVersion1.getGoodsInfo().getGoodsTypeFather().getId());
        System.out.println(goodsVersion1.getGoodsInfo().getGoodsTypeFather().getGoodsType().getId());
        System.out.println(goodsVersion);
        System.out.println(goodsVersion.size());*/
    }

    @org.junit.Test
    public void testService() {
        List<GoodsCar> goodsCar = goodsCarService.getGoodsCar("0");
        System.out.println(goodsCar);
    }

    @org.junit.Test
    public void testa() {
        //goodsCarService.deleteGoodsCar("2");
        //GoodsCar goodsCar1 = goodsCar.get(0);
//        System.out.println(goodsCar1.getUserId().getId());
//        System.out.println(goodsCar1.getNum());
//        System.out.println(goodsCar1.getGoodsVersion());
//        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        System.out.println(goodsCar1.getGoodsVersion().getId());
//        System.out.println(goodsCar1.getGoodsVersion().getGoodsInfo().getId());
//        System.out.println(goodsCar1.getGoodsVersion().getGoodsInfo().getGoodsTypeFather().getId());
//        System.out.println(goodsCar1.getGoodsVersion().getGoodsInfo().getGoodsTypeFather().getGoodsType().getId());
    }
}
