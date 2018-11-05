package com.xiaomi.mishop.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.xiaomi.mishop.entity.GoodsCar;
import com.xiaomi.mishop.entity.GoodsInfo;
import com.xiaomi.mishop.entity.GoodsVersion;
import com.xiaomi.mishop.persistence.Result;
import com.xiaomi.mishop.service.UiGoodsInfoService;
import com.xiaomi.mishop.utils.HttpClientUtils;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@Service
public class UiGoodsInfoServiceImpl implements UiGoodsInfoService {
    @Override
    public List<GoodsInfo> findlist1(GoodsInfo goodsInfo) {
        String s = HttpClientUtils.get("http://localhost:8081/goodsInfo1");
        return JSON.parseObject(s, new TypeReference<List<GoodsInfo>>() {
        });
    }

    @Override
    public Result<GoodsInfo> findlist(GoodsInfo goodsInfo) {
        String s = HttpClientUtils.get("http://localhost:8081/goodsInfo");
        return JSON.parseObject(s, new TypeReference<Result<GoodsInfo>>() {
        });
    }

    @Override
    public List<GoodsVersion> xiangqing(String id) {
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        String s = HttpClientUtils.post("http://localhost:8081/xiangqing", map);
        return JSON.parseObject(s, new TypeReference<List<GoodsVersion>>() {
        }.getType());
    }

    @Override
    public void guowuche(Long id, String userId) {
        String s = id + "";
        Map<String, String> map = new HashMap<>();
        map.put("goodsVersionId", s);
        map.put("userId", userId);
        HttpClientUtils.post("http://localhost:8081/savegouwuche", map);
    }
}
