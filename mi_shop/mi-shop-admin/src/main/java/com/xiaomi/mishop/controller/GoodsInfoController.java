package com.xiaomi.mishop.controller;

import com.alibaba.fastjson.JSON;
import com.xiaomi.mishop.entity.GoodsInfo;
import com.xiaomi.mishop.entity.GoodsType;
import com.xiaomi.mishop.entity.GoodsVersion;
import com.xiaomi.mishop.persistence.BaseController;
import com.xiaomi.mishop.persistence.Result;
import com.xiaomi.mishop.service.GoodsInfoService;
import com.xiaomi.mishop.webSupport.Page;
import com.xiaomi.mishop.webSupport.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/category")
public class GoodsInfoController extends BaseController<GoodsInfoService,GoodsType>{

    @RequestMapping("/list")
    public String list(GoodsVersion goodsVersion,Model model, @ModelAttribute("message")String message){
        List<GoodsVersion> list=service.queryGoodsInfo();
        model.addAttribute("list",list);
        model.addAttribute("message",message);
        return "category/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id,Model model,RedirectAttributes redirectAttributes){
        Result result=service.delete(id);
        if(result.getStatus()==Result.ERROR_STATUS){
            redirectAttributes.addFlashAttribute("message",result.getMessage());
        }else {
            redirectAttributes.addFlashAttribute("message","删除成功！");
        }
        return "redirect:/category/list";
    }
    @RequestMapping("/form")
    public String form(Long id,Model model){
        if(id!=null && id.longValue()>0){
            GoodsVersion Good=service.getById(id);
            System.out.println(Good);
            model.addAttribute("Good",Good);
        }
        return "category/form";
    }

    @RequestMapping("/edit")
    public String edit(GoodsVersion Good, RedirectAttributes redirectAttributes,Model model){
        Result result=null;
        if(Good.getId()!=null && Good.getId().longValue()>0){
           result = service.update(Good);
        }
        if(result.getStatus()==Result.SUCCESS_STATUS) {
            redirectAttributes.addFlashAttribute("message","新增成功！");
            return "redirect:/category/list";
        }else {
            model.addAttribute("errorMessage",result.getMessage());
            return "category/form";
        }
    }

    @RequestMapping("/search")
    public String list(String goodsName,Model model){
        List<GoodsVersion> list=service.search(goodsName);
        model.addAttribute("list",list);
        return "category/list";
    }

    @RequestMapping(value = "/treeData",produces ="application/json;charset=utf-8" )
    @ResponseBody
    public String treeData(Long id){
        if(id==null){
            id=3L;
        }
        List<GoodsType> list=service.queryChildrenType(id);
        System.out.println(list);
        return JSON.toJSONString(list);//[{id:86,name:"首页"},{id:87,name:"列表页面"}]
    }

    @RequestMapping("/addform")
    public String test(){
        return "category/addform";
    }








}
