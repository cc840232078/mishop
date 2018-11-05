package com.xiaomi.mishop.dao;

import com.xiaomi.mishop.entity.OrderDetail;
import com.xiaomi.mishop.persistence.BaseDao;

import java.util.List;

public interface OrderDetailDao extends BaseDao<OrderDetail> {
    public List<OrderDetail> getListById(Long id);
}
