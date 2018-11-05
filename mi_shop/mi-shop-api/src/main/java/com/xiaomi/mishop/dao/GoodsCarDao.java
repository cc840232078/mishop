package com.xiaomi.mishop.dao;

import com.xiaomi.mishop.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsCarDao {
    List<Integer> getGoodsVersionId(@Param("userid") String userid);

    List<GoodsVersion> getGoodsVersion(List<Integer> list);

    List<GoodsCar> getGoodsCar(@Param("id") String userid);

    List<Address> getgoodsCarAddress(@Param("id") String userid);

    void deletegGoodesCar(@Param("id") String userId);

    void createOrder(Order od);

    void createOrderDetail(@Param("orderDetailList") List<OrderDetail> orderDetailList);

    void deleteGoodesCar(@Param("userId") String userId, @Param("goodsVersionId") String goodsVersionId);

    void modifyNum(@Param("userId") String userId, @Param("goodsVersionNum") String goodsVersionNum, @Param("goodsVersionId") String goodsVersionId);
}
