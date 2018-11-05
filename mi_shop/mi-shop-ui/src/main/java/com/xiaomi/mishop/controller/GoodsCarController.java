package com.xiaomi.mishop.controller;

import com.xiaomi.mishop.entity.*;
import com.xiaomi.mishop.service.GoodsCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class GoodsCarController {
    @Autowired
    private GoodsCarService goodsCarService;

    /*@RequestMapping("goodsCar")
    public String goodsCar(User user, HttpSession httpSession, Model model) {
        //User user = (User) httpSession.getAttribute("user");
        //User user = new User();
        user.setId(1l);
        //获取所有的购物车商品信息
        List<GoodsVersion> list = goodsCarService.getGoodsVersion(user);
        //获取所有的购物车
        List<GoodsCar> goodsCarList = goodsCarService.getGoodsCar(user);
        //List<Integer> goodsNum=
        if (list != null) {
            model.addAttribute("GoodsVersionList", list);
        }
        return "gouwuche";
    }*/

    @RequestMapping("goodsCar")
//    public String goodsCar(User user, HttpSession httpSession, Model model) {
    public String goodsCar(HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("user");
        //User user = new User();
        //user.setId(1l);
        //获取所有的购物车商品信息
        //List<GoodsVersion> list = goodsCarService.getGoodsVersion(user);
        //获取所有的购物车
        List<GoodsCar> goodsCarList = goodsCarService.getGoodsCar(user);
        //List<Integer> goodsNum=
        if (goodsCarList != null) {
            model.addAttribute("GoodsVersionList", goodsCarList);
        }
        return "gouwuche";
    }

    @RequestMapping("jiesuan")
    public String pay() {
        return "redirect:/jiesuanAndAddress";
    }

    @RequestMapping("jiesuanAndAddress")
    public String pays(HttpSession httpSession, Model model) {
        User user = (User) httpSession.getAttribute("user");
        /*User user = new User();
        user.setId(1l);*/
        //获取该用户的购物车信息
        List<GoodsCar> goodsCarList = goodsCarService.getGoodsCar(user);
        //获取该用户的地址信息
        List<Address> addresseList = goodsCarService.getAddress(user);
        model.addAttribute("GoodsVersionList", goodsCarList);
        model.addAttribute("AddressList", addresseList);
        //goodsCarService.get
        return "pay";
    }

    @RequestMapping("success")
    public String success(Order order, Model model, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        /*User user = new User();
        user.setId(1l);*/
        order.setUserId(user);
        goodsCarService.submitorder(order);
        model.addAttribute("order", order);
        return "success";
    }

    @RequestMapping(value = "deleteGoodsCar")
    @ResponseBody
    public void deleteGoodsCar(Long userId, String goodsVersionId) {
        goodsCarService.deleteGoodsCar(Long.toString(userId), goodsVersionId);
    }

    @RequestMapping(value = "modifyNum")
    @ResponseBody
    public void modifyNum(Long userId, String goodsVersionNum,String goodsVersionId){
        goodsCarService.modifyNum(Long.toString(userId),goodsVersionNum,goodsVersionId);
    }
}
