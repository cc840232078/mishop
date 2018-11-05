package com.xiaomi.mishop.service;

import com.xiaomi.mishop.entity.*;

import java.util.List;

public interface GoodsCarService {
    List<GoodsVersion> getGoodsCarService(String userid);

    List<GoodsCar> getGoodsCar(String userid);

    List<Address> getgoodsCarAddress(String userid);

    /*void deleteGoodsCar(String userId);

    void createOrder(Order od);*/

    void setOrder(String order);

    void deleteGoodsCar(String userId, String goodsVersionId);

    void modifyNum(String userId, String goodsVersionNum, String goodsVersionId);
}
