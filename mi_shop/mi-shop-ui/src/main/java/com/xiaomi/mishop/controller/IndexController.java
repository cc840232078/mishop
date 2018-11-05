package com.xiaomi.mishop.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

@Controller
public class IndexController {
//    @RequestMapping(value = {"", "index"})
//    public String Login() {
//        return "index";
//    }
//
//    @RequestMapping(value = "pay")
//    public String pay() {
//        return "success";
//    }

    @RequestMapping(value = {"", "index"})
    public String index() {
        return "index";
    }

    @RequestMapping("ilogin")
    public String login() {
        return "login";
    }

    @RequestMapping("iregister")
    public String register() {
        return "register";
    }

    @RequestMapping("iself_info")
    public String self_info() {
        return "self_info";
    }

    @Autowired
    private Producer producer;

    /**
     * 产生验证码
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/kaptcha")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setDateHeader("Expires", 0);//过期时间（缓存时间）设置为0 0表示不缓存
        //清除缓存，禁止浏览器缓存图片
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");

        response.setContentType("image/jpeg");//设置返回数据类型是jpg
        String capText = producer.createText();//创建一个验证码
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);//将验证码放到session里面
        BufferedImage bi = producer.createImage(capText);//画出图片
        //输出
        OutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }
}
