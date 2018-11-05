package com.xiaomi.mishop.dao;

import com.xiaomi.mishop.entity.GoodsType;
import com.xiaomi.mishop.entity.GoodsVersion;
import com.xiaomi.mishop.persistence.BaseDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsInfoDao extends BaseDao<GoodsVersion> {
    //查询所有类型表
    List<GoodsVersion> queryGoodsInfo();
    // 模糊查询
    List<GoodsVersion> search(@Param("goodsName") String goodsName);
    //获取treedata数据
    List<GoodsType> queryChildrenType(@Param("id") Long id);











}
