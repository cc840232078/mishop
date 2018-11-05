package com.xiaomi.mishop.dao;

import com.xiaomi.mishop.entity.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDao {

    public List<Address> getAddressByUserId(Long userid);

    public int update(Address address);

    public int save(Address address);

    public int delete(Long id);
}
