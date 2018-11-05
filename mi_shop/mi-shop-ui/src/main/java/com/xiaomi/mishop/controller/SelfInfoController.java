package com.xiaomi.mishop.controller;

import com.xiaomi.mishop.service.APIService;
import com.xiaomi.mishop.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/self")
public class SelfInfoController {

    @Resource
    HttpServletRequest request;

    @Resource
    private APIService apiservice;

    @RequestMapping(value = "self_info")
    public String self_info() {
        //User user = (User) httpSession.getAttribute("user");
//        apiservice.userByID("/user/userByID?id=25");
//        request.getSession().setAttribute("user", user);
//        return new ModelAndView("self_info", "user", user);
        return "self_info";
    }

    //已修改
    @RequestMapping(value = "self_info_update")
    public String self_info_update(Model model,HttpSession httpSession) {
      User user = (User) httpSession.getAttribute("user");
//        //User user = (User) request.getSession().getAttribute("user");
//        user = apiservice.getUserInfo(user.getId());
        model.addAttribute("user", user);
        return "self_info_update";
    }

    @RequestMapping(value = "form")
    public String form(User user) {
        String result = apiservice.update("/user/updateUser", user);
        return "self_info";
    }


}
