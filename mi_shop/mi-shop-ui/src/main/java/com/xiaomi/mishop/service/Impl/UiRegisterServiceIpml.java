package com.xiaomi.mishop.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.persistence.Result;
import com.xiaomi.mishop.service.UiRegisterService;
import com.xiaomi.mishop.utils.HttpClientUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UiRegisterServiceIpml implements UiRegisterService {
    @Override
    public Result<User> save(User user, String repassword) {
        if (StringUtils.isAnyBlank(user.getUserName(), user.getEmail(), user.getPhone())) {
            return Result.fail("姓名，邮件名，手机号不能为空");
        }
        if (StringUtils.isAnyBlank(user.getPassword(), repassword)) {
            return Result.fail("密码不能为空");
        }
        if (!StringUtils.equals(user.getPassword(), repassword)) {
            return Result.fail("两次密码输入不一致");
        }
        Map<String, String> param = new HashMap<>();
        param.put("userName", user.getUserName());
        param.put("truename", user.getTruename());
        param.put("password", user.getPassword());
        param.put("email", user.getEmail());
        param.put("phone", user.getPhone());
        String userMessage = HttpClientUtils.post("http://localhost:8081/save", param);
        return JSON.parseObject(userMessage, new TypeReference<Result<User>>() {
        });
    }
}
