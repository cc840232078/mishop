package com.xiaomi.mishop.service;

import com.xiaomi.mishop.entity.Address;
import com.xiaomi.mishop.entity.Order;
import com.xiaomi.mishop.entity.OrderDetail;
import com.xiaomi.mishop.entity.User;

import java.util.List;

public interface APIService {

    User userByID(String requesturl);

    List<Order> orderByID(String requesturl);

    List<OrderDetail> orderDetailByID(String requesturl);

    String update(String requesturl, User user);

    List<Address> addressByID(String requesturl);

    void saveAddress(String requesturl, Address address);

    void updateAddress(String requesturl, Address address);

    void deleteAddress(String requesturl);

    User getUserInfo(Long id);
}
