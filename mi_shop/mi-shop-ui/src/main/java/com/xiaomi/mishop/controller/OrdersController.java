package com.xiaomi.mishop.controller;

import com.xiaomi.mishop.dto.Orders;
import com.xiaomi.mishop.service.APIService;
import com.xiaomi.mishop.entity.Order;
import com.xiaomi.mishop.entity.OrderDetail;
import com.xiaomi.mishop.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/order")
public class OrdersController {


    @Resource
    private APIService apiservice;

    @Resource
    HttpServletRequest request;


    @RequestMapping(value = "orderdt")
    public ModelAndView dingdan(String id) {
        User user = (User) request.getSession().getAttribute("user");
        List<Order> order = apiservice.orderByID("/order/orderByID?id=" + user.getId());
        List<Order> order3 = new ArrayList<>();
        for (Order order1 : order) {
            if (order1.getId().toString().equals(id)) {
                order3.add(order1);
            }
        }
        return new ModelAndView("orderdt", "orders3", order3);
    }

    @RequestMapping(value = "dingdanzhongxin")
    public ModelAndView dingdanzhongxin() {
        User user = (User) request.getSession().getAttribute("user");
        List<Order> order = apiservice.orderByID("/order/orderByID?id=" + user.getId());
        List<List<OrderDetail>> odlists = new ArrayList<>();
        for (Order order1 : order) {

            List<OrderDetail> odlist = apiservice.orderDetailByID("/orderdt/oderdtByID?id=" + order1.getId());
            odlists.add(odlist);
        }
        Orders orders = new Orders();
        orders.setOlist(order);
        orders.setOdlists(odlists);
        orders.setUser(user);
        return new ModelAndView("/dingdanzhongxin", "orders", orders);
    }


}
