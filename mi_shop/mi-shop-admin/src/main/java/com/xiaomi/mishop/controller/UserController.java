package com.xiaomi.mishop.controller;

import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.persistence.BaseController;
import com.xiaomi.mishop.persistence.Result;
import com.xiaomi.mishop.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController<UserService,User> {

    @Autowired
    private UserService userService;

    private User user;


    @ResponseBody
    @RequestMapping(value = "page",method = RequestMethod.GET)
    public Map<String,Object> page(HttpServletRequest request, User user){
        String strDraw = request.getParameter("draw");
        String strStart = request.getParameter("start");
        String strLength = request.getParameter("length");
        int count = userService.count(user);
        int draw = strDraw == null ? 0 : Integer.parseInt(strDraw);
        int start = strStart == null ? 0 : Integer.parseInt(strStart);
        int length = strLength == null ? 0 : Integer.parseInt(strLength);
        List<User> users = userService.page(start, length,user);

        Map<String, Object> result = new HashMap<>();
        result.put("draw",draw);
        result.put("data",users);
        result.put("recordsTotal",count);
        result.put("recordsFiltered",count);
        return result;
    }

    @ModelAttribute
    public User getById(Long id){
        User user = null;
        if (id != null){
            user = userService.getById(id);
        }

        else {
            user = new User();
        }
        return user;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model){
        return "user/user_list";
    }

    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String form(User user){
        return "user/user_form";
    }

    @RequestMapping(value = "/save")
    public String save(User user, RedirectAttributes redirectAttributes, Model model){
        Result baseResult = userService.save(user);
        if (baseResult.getStatus() == 200){
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/user/list";
        }

        else {
            model.addAttribute("baseResult", baseResult);
            return "user/user_form";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result delete(String ids){
        Result baseResult = null;
        if (StringUtils.isNotBlank(ids)){
            String[] idArray = ids.split(",");
            userService.deleteMulti(idArray);
            baseResult = Result.success("删除成功","200");
        }
        else {
            baseResult = Result.fail("删除失败");
        }
        return baseResult;
    }
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String showDetail(User user){
        return "user/user_detail";
    }


}
