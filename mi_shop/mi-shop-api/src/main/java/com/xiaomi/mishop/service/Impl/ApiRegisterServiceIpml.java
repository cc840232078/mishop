package com.xiaomi.mishop.service.Impl;

import com.xiaomi.mishop.dao.ApiRegisterDao;
import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.persistence.Result;
import com.xiaomi.mishop.service.ApiRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

@Service
public class ApiRegisterServiceIpml implements ApiRegisterService {
    @Autowired
    private ApiRegisterDao apiRegisterDao;

    @Override
    public Result<User> save(User user) {
        int countphone = apiRegisterDao.queryByPhone(user.getPhone());
        if (countphone > 0) {
            return Result.fail("电话号码已注册");
        }
        int countuserName = apiRegisterDao.queryByUserName(user.getUserName());
        if (countuserName > 0) {
            return Result.fail("用户名已注册");
        }
        int countemail = apiRegisterDao.queryByEmail(user.getEmail());
        if (countemail > 0) {
            return Result.fail("邮箱已注册");
        }
        Date date = new Date();
        user.setCreated(date);
        user.setUpdated(date);
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        apiRegisterDao.save(user);
        return Result.success("注册成功", user);
    }
}
