package com.xiaomi.mishop.service;

import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.persistence.BaseService;
import com.xiaomi.mishop.persistence.Result;

import java.util.List;

public interface UserService extends BaseService<User> {

    List<User> page(int start, int length, User user);

    int count(User user);

    Result save(User user);

    void deleteMulti(String[] ids);
}
