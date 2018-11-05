package com.xiaomi.mishop.controller;

import com.alibaba.fastjson.JSON;
import com.xiaomi.mishop.entity.GoodsCar;
import com.xiaomi.mishop.entity.GoodsInfo;
import com.xiaomi.mishop.entity.GoodsVersion;
import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.persistence.BaseController;
import com.xiaomi.mishop.persistence.Result;
import com.xiaomi.mishop.service.GoodsInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
public class GoodsInfoController extends BaseController<GoodsInfoService, GoodsInfo> {
    @Autowired
    private GoodsInfoService goodsInfoService;


    @RequestMapping(value = "/goodsInfo", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String goodsInfo(GoodsInfo goodsInfo) {
        Result list = service.findList(goodsInfo);
        if (list != null) {
            return JSON.toJSONString(list);
        } else {

            return "";
        }
    }

    @RequestMapping(value = "/goodsInfo1", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String goodsInfo1(GoodsInfo goodsInfo) {
        List<GoodsInfo> list = goodsInfoService.findList1(goodsInfo);
        if (list != null) {
            return JSON.toJSONString(list);
        } else {

            return "";
        }
    }

    @RequestMapping(value = "/xiangqing", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String xiangqing(@Param("id") String id) {
        List<GoodsVersion> list = goodsInfoService.xiangqing(id);
        if (list != null) {
            return JSON.toJSONString(list);
        } else {
            return "";
        }

    }


}
