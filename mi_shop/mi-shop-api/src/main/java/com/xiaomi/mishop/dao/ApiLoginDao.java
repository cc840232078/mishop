package com.xiaomi.mishop.dao;

import com.xiaomi.mishop.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiLoginDao {
    User queryByUserNameAndPassword(@Param("username") String username, @Param("password") String password);
}
