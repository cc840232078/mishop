package com.xiaomi.mishop.persistence;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseController<S extends BaseService, T extends BaseEntity> {
    @Autowired
    protected S service;
}
