package com.xiaomi.mishop.dto;

import com.xiaomi.mishop.entity.Order;
import com.xiaomi.mishop.entity.OrderDetail;
import com.xiaomi.mishop.entity.User;
import lombok.Data;

import java.util.List;

@Data
public class Orders {
   private List<Order> olist;
   private List<List<OrderDetail>>  odlists;
   private User user;

}
