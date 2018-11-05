package com.xiaomi.mishop.dao;

import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.persistence.BaseDao;

public interface UserDao extends BaseDao<User> {

    public int updateUser(User user);

}
