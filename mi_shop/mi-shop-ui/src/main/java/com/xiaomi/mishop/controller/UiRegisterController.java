package com.xiaomi.mishop.controller;

import com.xiaomi.mishop.config.EmailConfig;
import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.persistence.Result;
import com.xiaomi.mishop.service.UiRegisterService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UiRegisterController {
    @Autowired
    private UiRegisterService uiRegisterService;

    @RequestMapping("register")
    public String register(User user, String repassword, String code, Model model, RedirectAttributes redirectAttributes) {
        if (StringUtils.isBlank(code)) {
            model.addAttribute("message", "验证码不能为空");
            return "register";
        }
        Result result = uiRegisterService.save(user, repassword);
        if (result.getStatus() == Result.SUCCESS_STATUS) {
            try {
                Email email = EmailConfig.getEmail();
                email.addTo(user.getEmail());
                email.setSubject("成功注册用户");
                email.setMsg("恭喜你：" + user.getUserName() + ",注册成功！");
                email.send();
            } catch (EmailException e) {
                e.printStackTrace();
            }
            return "login";
        } else {
            model.addAttribute("message", result.getMessage());
            return "register";
        }
    }
}
