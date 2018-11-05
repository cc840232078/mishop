package com.xiaomi.mishop.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.xiaomi.mishop.entity.GoodsCar;
import com.xiaomi.mishop.entity.GoodsVersion;
import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.persistence.BaseController;
import com.xiaomi.mishop.persistence.Result;
import com.xiaomi.mishop.service.GuowucheService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class GuowucheController extends BaseController<GuowucheService, GoodsCar> {

    @RequestMapping(value = "/savegouwuche", produces = "application/json;charset=utf-8")
    @ResponseBody
    public void goodsVersion(String goodsVersionId, String userId) {
        /*GoodsCar goodsCar = new GoodsCar();
        User user = new User();
        user.setId(1l);
        goodsCar.setUserId(user);
        Long i = Long.parseLong(goodsVersionId);
        GoodsVersion goodsVersion = new GoodsVersion();
        goodsVersion.setId(i);
        goodsCar.setGoodsVersion(goodsVersion);*/
        service.saveGoodsCar(goodsVersionId, userId);
        //return JSON.toJSONString(result);
    }

}
