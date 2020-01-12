package com.ag.dao;

import com.ag.entity.OrderDetail;
import com.ag.entity.OrderMaster;

public interface OrderDao {
    void insertOrderMaster(OrderMaster orderMaster);
    void insertOrderDetail(OrderDetail orderDetail);
}
