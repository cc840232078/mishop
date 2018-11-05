package com.xiaomi.mishop.service.Impl;

import com.xiaomi.mishop.dao.ApiLoginDao;
import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.persistence.Result;
import com.xiaomi.mishop.service.ApiLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiLoginServiceImpl implements ApiLoginService {
    @Autowired
    private ApiLoginDao apiLoginDao;

    @Override
    public User login(String username, String password) {
        User user = apiLoginDao.queryByUserNameAndPassword(username, password);
        System.out.println(user);
        if (user == null) {
            return null;
        }
        return user;
    }
}
