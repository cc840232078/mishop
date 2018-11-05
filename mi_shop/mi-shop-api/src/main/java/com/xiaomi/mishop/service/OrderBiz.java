package com.xiaomi.mishop.service;

import com.xiaomi.mishop.entity.Order;
import com.xiaomi.mishop.persistence.BaseService;

import java.util.List;

public interface OrderBiz extends BaseService<Order> {

    List<Order> getListByID(Long ID);

}
