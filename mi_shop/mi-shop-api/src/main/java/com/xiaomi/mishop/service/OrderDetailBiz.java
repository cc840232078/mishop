package com.xiaomi.mishop.service;

import com.xiaomi.mishop.entity.OrderDetail;
import com.xiaomi.mishop.persistence.BaseService;

import java.util.List;

public interface OrderDetailBiz extends BaseService<OrderDetail> {
    List<OrderDetail> getListById(Long id);
}
