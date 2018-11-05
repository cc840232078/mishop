package com.xiaomi.mishop.service;

import com.sun.org.apache.regexp.internal.RE;
import com.xiaomi.mishop.entity.GoodsInfo;
import com.xiaomi.mishop.entity.GoodsType;
import com.xiaomi.mishop.entity.GoodsVersion;
import com.xiaomi.mishop.persistence.BaseService;
import com.xiaomi.mishop.persistence.Result;

import java.util.List;

public interface GoodsInfoService extends BaseService<GoodsVersion>{
    List<GoodsVersion> queryGoodsInfo();

    List<GoodsVersion> search(String goodsName);

    List<GoodsType> queryChildrenType(Long id);








}
