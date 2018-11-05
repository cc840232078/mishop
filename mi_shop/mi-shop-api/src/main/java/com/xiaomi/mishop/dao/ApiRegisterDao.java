package com.xiaomi.mishop.dao;

import com.xiaomi.mishop.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiRegisterDao {
    int queryByPhone(@Param("phone") String phone);

    int queryByUserName(@Param("username") String userName);

    int queryByEmail(@Param("email") String email);

    void save(User user);
}
