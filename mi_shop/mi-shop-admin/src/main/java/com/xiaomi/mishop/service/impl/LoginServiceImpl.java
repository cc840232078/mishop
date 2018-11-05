package com.xiaomi.mishop.service.impl;

import com.xiaomi.mishop.dao.LoginDao;
import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.persistence.Result;
import com.xiaomi.mishop.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    @Override
    public Result login(String email, String password) {
        String pwd = DigestUtils.md5DigestAsHex(password.getBytes());
        if (StringUtils.isBlank(pwd)) {
            return Result.fail("密码不能为空");
        }
        User user = loginDao.getByEmailAndPassword(email, pwd);
        if (user == null) {
            return Result.fail("账号密码有误");
        }
        return Result.success("", user);
    }
}
