package com.xiaomi.mishop.service;

import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.persistence.Result;

public interface ApiRegisterService {

    Result save(User user);

}
