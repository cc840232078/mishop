package com.xiaomi.mishop.service.Impl;

import com.xiaomi.mishop.dao.GuowucheDao;
import com.xiaomi.mishop.entity.GoodsCar;
import com.xiaomi.mishop.persistence.BaseServiceImpl;
import com.xiaomi.mishop.service.GuowucheService;
import org.springframework.stereotype.Service;

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
public class GouwucheServiceImpl extends BaseServiceImpl<GoodsCar, GuowucheDao> implements GuowucheService {
    @Override
    public void saveGoodsCar(String goodsVersionId, String userId) {
        dao.saveGoodsCar(goodsVersionId, userId);
    }
}
