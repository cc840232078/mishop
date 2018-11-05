package com.xiaomi.mishop.controller;

import com.alibaba.fastjson.JSON;
import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.service.Impl.UserBizImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/user")
public class UserAPIController {

    @Resource
    private UserBizImpl userBizImpl;

    @RequestMapping(value = "/userByID", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    public String userByID(String id) {
        Long ID = null;
        User user = null;
        if (id == null) {
            return "";
        } else {
            try {
                ID = Long.parseLong(id);
                user = userBizImpl.getById(ID);
            } catch (Exception e) {
                return "";
            }

        }
        if (user != null) {
            return JSON.toJSONString(user);
        } else {
            return "";
        }
    }


    @RequestMapping(value = "updateUser", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    @ResponseBody
    public String updateUser(String getId,
                             String getAddress,
                             String getHobby,
                             String getPassword,
                             String getUserName,
                             String getPhone,
                             String getSignature,
                             String getEmail) {

        User user = userBizImpl.getById(Long.parseLong(getId));
        user.setAddress(getAddress);
        user.setHobby(getHobby);
        user.setPassword(getPassword);
        user.setUserName(getUserName);
        user.setPhone(getPhone);
        user.setSignature(getSignature);
        user.setEmail(getEmail);
        int i = userBizImpl.updateUser(user);

        return i + "";

    }


}
