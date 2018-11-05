package com.xiaomi.mishop.service;

import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.persistence.BaseService;


public interface UserBiz extends BaseService<User> {

    public int updateUser(User user);

}
