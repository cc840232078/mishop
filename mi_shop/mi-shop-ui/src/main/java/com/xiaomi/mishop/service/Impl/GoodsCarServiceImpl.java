package com.xiaomi.mishop.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.xiaomi.mishop.entity.*;
import com.xiaomi.mishop.service.GoodsCarService;
import com.xiaomi.mishop.utils.HttpClientUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GoodsCarServiceImpl implements GoodsCarService {
    @Override
    public List<GoodsVersion> getGoodsVersion(User user) {
        Map<String, String> map = new HashMap<>();
        map.put("userid", Long.toString(user.getId()));
        //System.out.println(map.get("user"));
        String post = HttpClientUtils.post("http://127.0.0.1:8081/goodsCar", map);
        return JSON.parseObject(post, new TypeReference<List<GoodsVersion>>() {
        });
    }

    @Override
    public List<GoodsCar> getGoodsCar(User user) {
        Map<String, String> map = new HashMap<>();
        map.put("userid", Long.toString(user.getId()));
        //System.out.println(map.get("user"));
        String post = HttpClientUtils.post("http://127.0.0.1:8081/goodsCar", map);
        return JSON.parseObject(post, new TypeReference<List<GoodsCar>>() {
        });
    }

    @Override
    public List<Address> getAddress(User user) {
        Map<String, String> map = new HashMap<>();
        map.put("userid", Long.toString(user.getId()));
        //System.out.println(map.get("user"));
        String post = HttpClientUtils.post("http://127.0.0.1:8081/goodsCarAddress", map);
        return JSON.parseObject(post, new TypeReference<List<Address>>() {
        });
    }

    @Override
    public void submitorder(Order order) {
        //设置订单时间
        order.setOCreadedate(new Date());
        //创建订单id
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(2018);
        for (int i = 1; i < 6; i++) {
            stringBuffer.append(random.nextInt(10));
        }
        order.setId(Long.valueOf(stringBuffer.toString()));
        //设置订单的状态
        order.setOStarve("已支付");
        Map<String, String> map = new HashMap<>();
        String orderString = JSON.toJSONString(order);
        map.put("order", orderString);
        //System.out.println(map.get("user"));
        HttpClientUtils.post("http://127.0.0.1:8081/submitorder", map);
    }

    @Override
    public void deleteGoodsCar(String userId, String goodsVersionId) {
        String url = "http://127.0.0.1:8081/deleteGoodsCar?userId=" + userId + "&goodsVersionId=" + goodsVersionId;
        HttpClientUtils.get(url);
    }

    @Override
    public void modifyNum(String userId, String goodsVersionNum, String goodsVersionId) {
        String url = "http://127.0.0.1:8081/modifyNum?userId=" + userId + "&goodsVersionNum=" + goodsVersionNum + "&goodsVersionId=" + goodsVersionId;
        HttpClientUtils.get(url);
    }
}
