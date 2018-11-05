package com.xiaomi.mishop.service.Impl;

import com.alibaba.fastjson.JSON;
import com.xiaomi.mishop.dao.GoodsCarDao;
import com.xiaomi.mishop.entity.*;
import com.xiaomi.mishop.service.GoodsCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsCarServiceImpl implements GoodsCarService {

    @Autowired
    private GoodsCarDao goodsCarDao;

    @Override
    public List<GoodsVersion> getGoodsCarService(String userid) {
        //获取id所对应的所有商品版本id
        List<Integer> list = goodsCarDao.getGoodsVersionId(userid);
        //如果不为空，去获取所有的商品版本
        System.out.println(list);
        if (list != null) {
            List<GoodsVersion> listGoodsVersion = goodsCarDao.getGoodsVersion(list);
            return listGoodsVersion;
        } else {
            return null;
        }
    }

    @Override
    public List<GoodsCar> getGoodsCar(String userid) {
        List<GoodsCar> list = goodsCarDao.getGoodsCar(userid);


        /*//获取id所对应的所有商品版本id
        List<Integer> list = goodsCarDao.getGoodsCarId(userid);
        //如果不为空，去获取所有的商品版本
        System.out.println(list);*/
        if (list != null) {
            //List<GoodsVersion> listGoodsVersion = goodsCarDao.getGoodsVersion(list);
            //List<GoodsCar> listGoodsCar = goodsCarDao.getGoodsCar(list);
            return list;
        } else {
            return null;
        }
    }

    @Override
    public List<Address> getgoodsCarAddress(String userid) {
        List<Address> list = goodsCarDao.getgoodsCarAddress(userid);
        if (list != null) {
            return list;
        } else {
            return null;
        }
    }

    /*@Override
    public void deleteGoodsCar(String userId) {
        //不用了
        goodsCarDao.deletegGoodesCar(userId);
    }

    @Override
    public void createOrder(Order od) {
        //不用了
        goodsCarDao.createOrder(od);
    }*/

    @Override
    public void setOrder(String order) {
        Order od = JSON.parseObject(order, Order.class);
        String orderId = String.valueOf(od.getId());
        /**
         * 第一部分：创建订单表
         */
        goodsCarDao.createOrder(od);
        /**
         * 第二部分：创建订单详情表
         */
        //获取该用户的购物车
        Long userId = od.getUserId().getId();
        List<GoodsCar> goodsCarList = goodsCarDao.getGoodsCar(Long.toString(userId));
        //生成所有的订单详情 List<OrderDetail>
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail;
        for (GoodsCar goodsCar : goodsCarList) {
            orderDetail = new OrderDetail();
            //设置商品数量
            orderDetail.setGoodsnum(goodsCar.getNum());
            //设置总价
            orderDetail.setGoodsTotalPrice(goodsCar.getNum() * goodsCar.getGoodsVersion().getGoodsPrice());
            //设置order属性
            Order addOrder = new Order();
            addOrder.setId(Long.parseLong(orderId));
            //设置goodsVersion属性
            GoodsVersion addGoodsVersion = new GoodsVersion();
            //设置单价
            addGoodsVersion.setGoodsPrice(goodsCar.getGoodsVersion().getGoodsPrice());
            //设置goodsVersion所需的goodsInfo属性
            GoodsInfo addGoodsInfo = new GoodsInfo();
            //设置商品描述
            addGoodsInfo.setGoodsDescription(goodsCar.getGoodsVersion().getGoodsInfo().getGoodsDescription());
            //设置照片
            addGoodsInfo.setGoodsPic(goodsCar.getGoodsVersion().getGoodsInfo().getGoodsPic());
            //设置名字
            addGoodsInfo.setGoodsName(goodsCar.getGoodsVersion().getGoodsInfo().getGoodsName());
            //goodsversion添加goodsinfo
            addGoodsVersion.setGoodsInfo(addGoodsInfo);

            orderDetail.setOrder(addOrder);
            orderDetail.setGoodsVersion(addGoodsVersion);

            orderDetailList.add(orderDetail);
        }
        //System.out.println(orderDetailList);
        goodsCarDao.createOrderDetail(orderDetailList);
        /**
         * 第三部分：清空用户购物车里的数据
         */
        goodsCarDao.deletegGoodesCar(Long.toString(od.getUserId().getId()));
    }

    @Override
    public void deleteGoodsCar(String userId, String goodsVersionId) {
        goodsCarDao.deleteGoodesCar(userId, goodsVersionId);
    }

    @Override
    public void modifyNum(String userId, String goodsVersionNum, String goodsVersionId) {
        goodsCarDao.modifyNum(userId, goodsVersionNum, goodsVersionId);
    }
}
