package com.xiaomi.mishop.service.impl;

import com.xiaomi.mishop.dao.GoodsInfoDao;
import com.xiaomi.mishop.entity.GoodsInfo;
import com.xiaomi.mishop.entity.GoodsType;
import com.xiaomi.mishop.entity.GoodsVersion;
import com.xiaomi.mishop.persistence.BaseServiceImpl;
import com.xiaomi.mishop.persistence.Result;
import com.xiaomi.mishop.service.GoodsInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsInfoServiceImpl extends BaseServiceImpl<GoodsVersion, GoodsInfoDao> implements GoodsInfoService {

    @Override
    public List<GoodsVersion> queryGoodsInfo() {
        return dao.queryGoodsInfo();
    }

    @Override
    public List<GoodsVersion> search(String goodsName) {
        return dao.search(goodsName);
    }

    @Override
    public List<GoodsType> queryChildrenType(Long id) {
        return dao.queryChildrenType(id);
    }

    @Override
    public Result delete(Long id) {
        return super.delete(id);
    }

    @Override
    public Result update(GoodsVersion Good) {
        return super.update(Good);
    }

    @Override
    public GoodsVersion getById(Long id) {
        return super.getById(id);
    }









}
