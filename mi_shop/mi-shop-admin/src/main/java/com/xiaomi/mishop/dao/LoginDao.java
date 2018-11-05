package com.xiaomi.mishop.dao;

import com.xiaomi.mishop.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao {
    User getByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
