package com.xiaomi.mishop.service.Impl;

import com.xiaomi.mishop.dao.AddressDao;
import com.xiaomi.mishop.entity.Address;
import com.xiaomi.mishop.service.AddressBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBizImpl implements AddressBiz {

    @Autowired
    private AddressDao addressDao;

    @Override
    public List<Address> getAddressByUserId(Long userid) {
        return addressDao.getAddressByUserId(userid);
    }

    @Override
    public int update(Address address) {
        return addressDao.update(address);
    }

    @Override
    public int save(Address address) {
        return addressDao.save(address);
    }

    @Override
    public int delete(Long id) {
        return addressDao.delete(id);
    }
}
