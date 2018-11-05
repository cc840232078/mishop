package com.xiaomi.mishop.dao;

import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.persistence.BaseDao;

import java.util.List;
import java.util.Map;

public interface MemberDao  extends BaseDao<User> {
    List<User> page(Map<String, Object> params);

    int count(User user);

    void insert(User user);

    void deleteMulti(String[] ids);

    User getById(Long id);
}
