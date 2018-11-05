package com.xiaomi.mishop.service;

import com.xiaomi.mishop.entity.User;

public interface ApiLoginService {
    User login(String username, String password);
}
