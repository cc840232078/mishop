package com.xiaomi.mishop.service.Impl;

import com.xiaomi.mishop.dao.OrderDetailDao;
import com.xiaomi.mishop.entity.OrderDetail;
import com.xiaomi.mishop.persistence.BaseServiceImpl;
import com.xiaomi.mishop.service.OrderDetailBiz;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailBizImpl extends BaseServiceImpl<OrderDetail, OrderDetailDao> implements OrderDetailBiz {

    @Override
    public List<OrderDetail> getListById(Long id) {
        return dao.getListById(id);
    }
}
