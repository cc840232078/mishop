package com.xiaomi.mishop.service;

import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.persistence.Result;

public interface LoginService {
    Result login(String email, String password);
}
