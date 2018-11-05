package com.xiaomi.mishop.controller;

import com.xiaomi.mishop.persistence.Result;
import com.xiaomi.mishop.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = {"", "index"})
    public String index() {
        return "index";
    }

    @RequestMapping("login")
    public String login(String email, String password, HttpSession session, Model model) {

        Result result = loginService.login(email, password);
        if (result.getStatus() == Result.SUCCESS_STATUS) {
            session.setAttribute("loginUser", result.getData());
            System.out.println(result.getData());
            return "main";
        } else {
            model.addAttribute("message", result.getMessage());
            return "index";
        }
    }

}
