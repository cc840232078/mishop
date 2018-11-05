package com.xiaomi.mishop.controller;

import com.alibaba.fastjson.JSON;
import com.xiaomi.mishop.entity.OrderDetail;
import com.xiaomi.mishop.service.Impl.OrderDetailBizImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/orderdt")
public class OrderDTAPIController {

    @Resource
    private OrderDetailBizImpl orderDetailBizImpl;

    @RequestMapping(value = "/oderdtByID", produces = "application/json;charset=utf-8", method = RequestMethod.GET)
    @ResponseBody
    public String OrderDTByID(String id) {

        List<OrderDetail> orderDetail = null;
        Long ID = null;
        if (id == null) {
            return "";
        } else {
            try {
                ID = Long.parseLong(id);
                orderDetail = orderDetailBizImpl.getListById(ID);
            } catch (Exception e) {
                return "";
            }

        }
        if (orderDetail != null) {
            return JSON.toJSONString(orderDetail);
        } else {
            return "";
        }
    }


}
