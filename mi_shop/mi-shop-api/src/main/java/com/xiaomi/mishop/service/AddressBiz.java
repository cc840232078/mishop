package com.xiaomi.mishop.service;

import com.xiaomi.mishop.entity.Address;

import java.util.List;

public interface AddressBiz {

    public List<Address> getAddressByUserId(Long userid);

    public int update(Address address);

    public int save(Address address);

    public int delete(Long id);

}
