package com.xiaomi.mishop.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.TypeReference;
import com.xiaomi.mishop.service.APIService;
import com.xiaomi.mishop.entity.Address;
import com.xiaomi.mishop.entity.Order;
import com.xiaomi.mishop.entity.OrderDetail;
import com.xiaomi.mishop.entity.User;
import com.xiaomi.mishop.utils.HttpClientUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APIServiceImpl implements APIService {

    private String HEADER_FIELD = "http://";
    private String IP = "127.0.0.1";
    private String PORT = "8081";
    private String REQUEST = "/user/userByID?id=1";

    public String getHEADER_FIELD() {
        return HEADER_FIELD;
    }

    public void setHEADER_FIELD(String HEADER_FIELD) {
        this.HEADER_FIELD = HEADER_FIELD;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getPORT() {
        return PORT;
    }

    public void setPORT(String PORT) {
        this.PORT = PORT;
    }

    public String getREQUEST() {
        return REQUEST;
    }

    public void setREQUEST(String REQUEST) {
        this.REQUEST = REQUEST;
    }

    public User userByID(String requesturl) {
        this.REQUEST = requesturl;
        String url = HEADER_FIELD + IP + ":" + PORT + REQUEST;
        String data = HttpClientUtils.get(url);

        return JSON.parseObject(data, new TypeReference<User>() {
        });

    }

    @Override
    public List<Order> orderByID(String requesturl) {
        this.REQUEST = requesturl;
        String url = HEADER_FIELD + IP + ":" + PORT + REQUEST;
        String data = HttpClientUtils.get(url);
        List<Order> list = JSON.parseObject(data, new TypeReference<List<Order>>() {
        }.getType());
        return list;
    }

    @Override
    public List<OrderDetail> orderDetailByID(String requesturl) {
        this.REQUEST = requesturl;
        String url = HEADER_FIELD + IP + ":" + PORT + REQUEST;
        String data = HttpClientUtils.get(url);
        return JSON.parseObject(data, new TypeReference<List<OrderDetail>>() {
        }.getType());
    }

    @Override
    public String update(String requesturl, User user) {


        this.REQUEST = requesturl;
        String url = HEADER_FIELD + IP + ":" + PORT + REQUEST;
        Map<String, String> map = new HashMap<>();
        map.put("getId", user.getId().toString());
        map.put("getAddress", user.getAddress());
        map.put("getUserName", user.getUserName());
        map.put("getEmail", user.getEmail());
        map.put("getHobby", user.getHobby());
        map.put("getPassword", user.getPassword());
        map.put("getPhone", user.getPhone());
        map.put("getSignature", user.getSignature());
        return HttpClientUtils.post(url, map);

    }

    @Override
    public List<Address> addressByID(String requesturl) {
        String url = HEADER_FIELD + IP + ":" + PORT + requesturl;
        String data = HttpClientUtils.get(url);
        List<Address> list = JSON.parseObject(data, new TypeReference<List<Address>>() {
        }.getType());
        return list;

    }

    @Override
    public void saveAddress(String requesturl, Address address) {

        String url = HEADER_FIELD + IP + ":" + PORT + requesturl;
        Map<String, String> map = new HashMap<>();
        String address2 = JSON.toJSONString(address);
        map.put("address", address2);
        HttpClientUtils.post(url, map);


    }

    @Override
    public void updateAddress(String requesturl, Address address) {
        saveAddress(requesturl, address);

    }

    @Override
    public void deleteAddress(String requesturl) {
        String url = HEADER_FIELD + IP + ":" + PORT + requesturl;
        HttpClientUtils.get(url);

    }

    @Override
    public User getUserInfo(Long id) {
       /* Map<String, String> map = new HashMap<>();
        map.put("userId", Long.toString(user.getId()));
        //System.out.println(map.get("user"));
        String post = HttpClientUtils.post("http://127.0.0.1:8081/goodsCar", map);
        String url1 = "http://" + "127.0.0.1" + ":" + "8080" + requesturl;
        return JSON.parseObject(post, new TypeReference<List<GoodsVersion>>() {
        };*/
        return null;
    }


}
