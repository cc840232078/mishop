package com.xiaomi.mishop.service.Impl;

import com.alibaba.fastjson.JSON;
import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.service.UiLoginService;
import com.xiaomi.mishop.utils.HttpClientUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class UiLoginServiceImpl implements UiLoginService {
    @Override
    public User login(String username, String password) {
        if (StringUtils.isNotBlank(password)) {
            password = DigestUtils.md5DigestAsHex(password.getBytes());
        }
        Map<String, String> param = new HashMap<>();
        param.put("username", username);
        param.put("password", password);
        String result = HttpClientUtils.post("http://localhost:8081/queryUser", param);
        if (StringUtils.isBlank(result)) {
            return null;
        } else {
            return JSON.parseObject(result, User.class);
        }

    }
}
