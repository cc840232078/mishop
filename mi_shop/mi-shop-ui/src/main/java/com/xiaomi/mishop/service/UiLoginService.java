package com.xiaomi.mishop.service;

import com.xiaomi.mishop.entity.User;

public interface UiLoginService {
    User login(String username, String password);
}
