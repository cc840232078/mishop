package com.xiaomi.mishop.service;

import com.xiaomi.mishop.entity.GoodsInfo;
import com.xiaomi.mishop.entity.GoodsVersion;
import com.xiaomi.mishop.persistence.Result;

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
public interface UiGoodsInfoService {

    Result<GoodsInfo> findlist(GoodsInfo goodsInfo);

    List<GoodsInfo> findlist1(GoodsInfo goodsInfo);

    List<GoodsVersion> xiangqing(String id);

    void guowuche(Long id, String userId);
}
