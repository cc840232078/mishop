package com.xiaomi.mishop.persistence;

public interface BaseService<T extends BaseEntity> {

    /**
     * 通过id查询对象
     *
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 保存
     *
     * @param t
     * @return
     */
    Result save(T t);

    Result delete(Long id);

    Result update(T t);

    Result findList(T t);

    /**
     * current  当前第几页
     * pageSize 每页多少条
     */
    Result pageList(T user);
}
