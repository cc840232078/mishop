package com.xiaomi.mishop.dao;

import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.persistence.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserDao extends BaseDao<User> {

    List<User> page(Map<String, Object> params);

    int count(User user);

    void insert(User user);

    void deleteMulti(String[] ids);

}
