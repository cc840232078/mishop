package com.xiaomi.mishop.controller;

import com.google.code.kaptcha.Constants;
import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.persistence.Result;
import com.xiaomi.mishop.service.UiLoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UiLoginController {
    @Autowired
    private UiLoginService uiLoginService;

    @RequestMapping("login")
    public String login(String username, String password, String vcode, Model model, HttpSession session) {
        String code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if (StringUtils.isBlank(vcode)) {
            model.addAttribute("message", "验证码不能为空");
            return "login";
        }
        if (!StringUtils.equalsIgnoreCase(vcode, code)) {
            model.addAttribute("message", "验证码输入错误");
            return "login";
        }
        User user = uiLoginService.login(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "index";
        } else {
            model.addAttribute("message", "登陆失败");
            return "login";
        }


    }

}
