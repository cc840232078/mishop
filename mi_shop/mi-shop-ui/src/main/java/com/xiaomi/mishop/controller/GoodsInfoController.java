package com.xiaomi.mishop.controller;

import com.xiaomi.mishop.entity.GoodsInfo;
import com.xiaomi.mishop.entity.GoodsVersion;
import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.persistence.Result;
import com.xiaomi.mishop.service.UiGoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

//                          _ooOoo_                               //
//                         o8888888o                              //
//                         88" . "88                              //
//                         (| ^_^ |)                              //
//                         O\  =  /O                              //
//                      ____/`---'\____                           //
//                    .'  \\|     |//  `.                         //
//                   /  \\|||  :  |||//  \                        //
//                  /  _||||| -:- |||||-  \                       //
//                  |   | \\\  -  /// |   |                       //
//                  | \_|  ''\---/''  |   |                       //
//                  \  .-\__  `-`  ___/-. /                       //
//                ___`. .'  /--.--\  `. . ___                     //
//              ."" '<  `.___\_<|>_/___.'  >'"".                  //
//            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
//            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
//      ========`-.____`-.___\_____/___.-`____.-'========         //
//                           `=---='                              //
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
//            佛祖保佑       永不宕机     永无BUG                  //
@Controller
public class GoodsInfoController {
    @Autowired
    private UiGoodsInfoService uiGoodsInfoService;

    @RequestMapping(value = {"xiaomi"})
    public String xiaomi(Model model, GoodsInfo goodsInfo) {
        Result<GoodsInfo> result = uiGoodsInfoService.findlist(goodsInfo);
        model.addAttribute("result", result);
        return "xiaomi";
    }

    @RequestMapping(value = "/hongmi")
    public ModelAndView hongmi(Model model, GoodsInfo goodsInfo) {
        List<GoodsInfo> list = uiGoodsInfoService.findlist1(goodsInfo);
        return new ModelAndView("hongmi", "list", list);
    }

    @RequestMapping(value = "/xiangqing")
    public String xiangqing(String id, Model model) {
        List<GoodsVersion> xiangqing = uiGoodsInfoService.xiangqing(id);

        model.addAttribute("xiangqing", xiangqing);
        return "xiangqing";
    }

    @RequestMapping(value = "/gouwuche")
    public String gouwuche(Long id, Model model, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        //user.setId(1l);
        uiGoodsInfoService.guowuche(id, Long.toString(user.getId()));
        return "redirect:/goodsCar";
    }
}
