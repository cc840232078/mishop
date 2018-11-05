package com.xiaomi.mishop.controller;

import com.alibaba.fastjson.JSON;
import com.xiaomi.mishop.entity.Order;
import com.xiaomi.mishop.service.OrderBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Resource
    private OrderBiz orderBizImpl;

    @RequestMapping(value = "/orderByID", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    public String orderByID(String id) {
        List<Order> orders = null;
        if (id == null) {
            return "";
        } else {
            try {
                Long ID = Long.parseLong(id);
                orders = orderBizImpl.getListByID(ID);
            } catch (Exception e) {
                return "";
            }

        }
        if (orders != null) {
            return JSON.toJSONString(orders);
        } else {
            return "";
        }
    }


}
