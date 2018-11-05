package com.xiaomi.mishop.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.xiaomi.mishop.entity.Address;
import com.xiaomi.mishop.service.AddressBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/address")
public class AddressController {

    @Resource
    private AddressBiz addressBizImpl;

    @RequestMapping(value = "update", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public String update(String address) {
        Address address1 = JSON.parseObject(address, new TypeReference<Address>() {
        }.getType());
        int update = addressBizImpl.update(address1);
        return "update";
    }

    @RequestMapping(value = "save", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public String save(String address) {
        Address address1 = JSON.parseObject(address, Address.class);
        int save = addressBizImpl.save(address1);
        return "save";
    }

    @RequestMapping(value = "delete", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    public String delete(String adid) {

        int delete = addressBizImpl.delete(Long.parseLong(adid));
        return "delete" + delete;
    }

    @RequestMapping(value = "addressByUserId", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    public String addressByUserId(String id) {

        List<Address> addresses = addressBizImpl.getAddressByUserId(Long.parseLong(id));

        return JSON.toJSONString(addresses);
    }


}
