package com.xiaomi.mishop.service;

import com.xiaomi.mishop.entity.*;

import java.util.List;

public interface GoodsCarService {
    List<GoodsVersion> getGoodsVersion(User user);

    List<GoodsCar> getGoodsCar(User user);

    List<Address> getAddress(User user);

    void submitorder(Order order);

    void deleteGoodsCar(String userId, String goodsVersionId);

    void modifyNum( String userId, String goodsVersionNum,String goodsVersionId);
}
