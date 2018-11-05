package com.xiaomi.mishop.service.Impl;

import com.xiaomi.mishop.dao.GoodsInfoDao;
import com.xiaomi.mishop.entity.GoodsInfo;
import com.xiaomi.mishop.entity.GoodsVersion;
import com.xiaomi.mishop.persistence.BaseServiceImpl;
import com.xiaomi.mishop.persistence.Result;
import com.xiaomi.mishop.service.GoodsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class GoodsInfoServiceImpl extends BaseServiceImpl<GoodsInfo, GoodsInfoDao> implements GoodsInfoService {
    @Autowired
    private GoodsInfoDao goodsInfoDao;

    @Override
    public List<GoodsInfo> findList1(GoodsInfo goodsInfo) {
        return goodsInfoDao.findList1();
    }

    @Override
    public List<GoodsVersion> xiangqing(String id) {
        return goodsInfoDao.xiangqing(id);
    }
}
