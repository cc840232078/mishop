package com.xiaomi.mishop.controller;

import com.alibaba.fastjson.JSON;
import com.xiaomi.mishop.entity.*;
import com.xiaomi.mishop.persistence.Result;
import com.xiaomi.mishop.service.ApiLoginService;
import com.xiaomi.mishop.service.ApiRegisterService;
import com.xiaomi.mishop.service.GoodsCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ApiController {
    /**
     * 大超部分
     */
    @Autowired
    private ApiLoginService apiLoginService;

    @RequestMapping(value = "/queryUser", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String queryUser(String username, String password) {
        User user = apiLoginService.login(username, password);
        if (user == null) {
            return "";
        }
        return JSON.toJSONString(user);

    }

    @Autowired
    private ApiRegisterService apiRegisterService;

    @RequestMapping(value = "/save", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String save(User user) {
        Result<User> result = apiRegisterService.save(user);
        return JSON.toJSONString(result);

    }

    /**
     * 陈齐部分
     */
    @Autowired
    private GoodsCarService goodsCarService;

   /* @RequestMapping(value = "goodsCar", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String goodsCar(String userid) {
        //获取id所对应的所有商品值
        List<GoodsVersion> list = goodsCarService.getGoodsCarService(userid);
        if (list != null) {
            return JSON.toJSONString(list);
        } else {
            return "";
        }
    }*/

    @RequestMapping(value = "goodsCar", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String goodsCar(String userid) {
        //获取id所对应的所有商品值
        List<GoodsCar> list = goodsCarService.getGoodsCar(userid);
        if (list != null) {
            return JSON.toJSONString(list);
        } else {
            return "";
        }
    }

    @RequestMapping(value = "goodsCarAddress", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String goodsCarAddress(String userid) {
        //获取id所对应的所有商品值
        List<Address> list = goodsCarService.getgoodsCarAddress(userid);
        if (list != null) {
            return JSON.toJSONString(list);
        } else {
            return "";
        }
    }

    @RequestMapping(value = "submitorder")
    public void submitorder(String order) {
        goodsCarService.setOrder(order);

        //删除该用户里的所有购物车商品
        //goodsCarService.deleteGoodsCar(Long.toString(od.getUserId().getId()));
        //编辑订单

    }

    @RequestMapping(value = "deleteGoodsCar")
    @ResponseBody
    public void deleteGoodsCar(String userId, String goodsVersionId) {
        goodsCarService.deleteGoodsCar(userId, goodsVersionId);
        //return "";
    }

    @RequestMapping(value = "modifyNum")
    @ResponseBody
    public void modifyNum(String userId, String goodsVersionNum, String goodsVersionId) {
        goodsCarService.modifyNum(userId, goodsVersionNum, goodsVersionId);
        //return "";
    }
}
