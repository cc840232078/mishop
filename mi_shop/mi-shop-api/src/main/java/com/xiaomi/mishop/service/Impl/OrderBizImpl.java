package com.xiaomi.mishop.service.Impl;

import com.xiaomi.mishop.dao.OrderDao;
import com.xiaomi.mishop.entity.Order;
import com.xiaomi.mishop.persistence.BaseServiceImpl;
import com.xiaomi.mishop.service.OrderBiz;
import com.xiaomi.mishop.service.UserBiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderBizImpl extends BaseServiceImpl<Order, OrderDao> implements OrderBiz {
    @Override
    public List<Order> getListByID(Long ID) {
        return dao.getListByID(ID);
    }
}
