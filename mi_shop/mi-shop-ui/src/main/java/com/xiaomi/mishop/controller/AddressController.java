package com.xiaomi.mishop.controller;

import com.xiaomi.mishop.service.APIService;
import com.xiaomi.mishop.entity.Address;
import com.xiaomi.mishop.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/address")
public class AddressController {

    @Resource
    private APIService apiservice;

    @Resource
    private HttpServletRequest request;

    //跳转到地址新增页面
    @RequestMapping(value = "save")
    public String save(Address address) {

        return "address_add";
    }

    //新增地址表单
    @RequestMapping(value = "saveform")
    public String saveform(Address address, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");


        /*String s = null;
        try {
            s = new String("否".getBytes(), "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        address.setIsDefault("0");
        //User user = (User) request.getSession().getAttribute("user");
        address.setUser(user);
        apiservice.saveAddress("/address/save", address);

        return "redirect:/address/addresslist?id=" + user.getId();
    }


    //跳转到地址更新页
    @RequestMapping(value = "update")
    public String update(String id, Model model) {
        User user = (User) request.getSession().getAttribute("user");
        List<Address> addresses = apiservice.addressByID("/address/addressByUserId?id=" + user.getId());
        Address address1 = null;
        for (Address address : addresses) {
            if (address.getId().toString().equals(id)) {
                address1 = address;
                break;
            }
        }
        model.addAttribute("address", address1);
        return "address_update";
    }

    //提交地址表单
    @RequestMapping(value = "updateform")
    public String updateform(Address address) {

        apiservice.updateAddress("/address/update", address);
        User user = (User) request.getSession().getAttribute("user");
        return "redirect:/address/addresslist?id=" + user.getId();
    }


    //获取地址列表
    @RequestMapping(value = "addresslist")
    public ModelAndView addresslist() {
        User user = (User) request.getSession().getAttribute("user");
        List<Address> addresses = apiservice.addressByID("/address/addressByUserId?id=" + user.getId());
        return new ModelAndView("address", "addresses", addresses);
    }

    //删除地址
    @RequestMapping(value = "delete")
    public String delete(String adid) {

        apiservice.deleteAddress("/address/delete?adid=" + adid);
        User user = (User) request.getSession().getAttribute("user");
        return "redirect:/address/addresslist?id=" + user.getId();
    }

    //设置默认地址
    @RequestMapping(value = "defaultaddress")
    public String defaultaddress(String adid) {
        User user = (User) request.getSession().getAttribute("user");
        List<Address> addresses = apiservice.addressByID("/address/addressByUserId?id=" + user.getId());
        for (Address address : addresses) {
            if (address.getId().toString().equals(adid)) {
                address.setIsDefault("1");
                apiservice.updateAddress("/address/update", address);
            } else {
                address.setIsDefault("0");
                apiservice.updateAddress("/address/update", address);
            }
        }


        return "redirect:/address/addresslist?id=" + user.getId();
    }


}
