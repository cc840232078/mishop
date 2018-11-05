package com.xiaomi.mishop.service.Impl;

import com.xiaomi.mishop.dao.UserDao;
import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.persistence.BaseServiceImpl;
import com.xiaomi.mishop.persistence.Result;
import com.xiaomi.mishop.service.UserBiz;
import org.springframework.stereotype.Service;

@Service
public class UserBizImpl extends BaseServiceImpl<User, UserDao> implements UserBiz {

    @Override
    public int updateUser(User user) {
        return dao.updateUser(user);
    }
}
