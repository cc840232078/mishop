package com.xiaomi.mishop.dao;

import com.xiaomi.mishop.entity.Order;
import com.xiaomi.mishop.persistence.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends BaseDao<Order> {
    List<Order> getListByID(Long ID);

}
