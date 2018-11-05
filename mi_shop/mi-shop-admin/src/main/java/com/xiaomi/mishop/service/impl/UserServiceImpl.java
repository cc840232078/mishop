package com.xiaomi.mishop.service.impl;

import com.xiaomi.mishop.dao.UserDao;
import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.persistence.BaseServiceImpl;
import com.xiaomi.mishop.persistence.Result;
import com.xiaomi.mishop.service.UserService;
import com.xiaomi.mishop.utils.PattenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseServiceImpl<User,UserDao> implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public List<User> page(int start, int length, User user) {
        Map<String, Object> parmas = new HashMap<>();
        parmas.put("start",start);
        parmas.put("length",length);
        parmas.put("user",user);
        return userDao.page(parmas);
    }

    @Override
    public int count(User user) {
        return userDao.count(user);
    }

    @Override
    public Result save(User user) {
        user.setUpdated(new Date());
        Result baseResult = checkUser(user);
        if (baseResult.getStatus() == 200){
            if (user.getId() == null){
                user.setCreated(new Date());
                user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
                userDao.insert(user);

            }
            else {
                userDao.update(user);
            }
            baseResult.setMessage("用户信息保存成功");
        }
        return baseResult;

    }

    @Override
    public void deleteMulti(String[] ids) {
        userDao.deleteMulti(ids);
    }

    private Result checkUser(User user){
        Result baseResult = Result.success("保存信息成功","200");
        if (StringUtils.isBlank(user.getEmail())){
            baseResult = Result.fail("邮件不能为空");
        }

        else if (StringUtils.isBlank(user.getPassword())){
            baseResult = Result.fail("密码不能为空");
        }

        else if (StringUtils.isBlank(user.getUserName())){
            baseResult = Result.fail("姓名不能为空");
        }

        else if (StringUtils.isBlank(user.getPhone())){
            baseResult = Result.fail("电话不能为空");
        }

        else if (!PattenUtil.validateEmail(user.getEmail())){
            baseResult = Result.fail("邮箱格式不正确，请重新输入");
        }

        else if (!PattenUtil.validatePhone(user.getPhone())){
            baseResult = Result.fail("手机格式不正确，请重新输入");
        }
        return baseResult;
    }
}
