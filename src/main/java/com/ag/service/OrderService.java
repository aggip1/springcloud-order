package com.ag.service;

import com.ag.entity.OrderDtoArgs;
import com.ag.entity.OrderResultDto;

public interface OrderService {
    OrderResultDto insert(OrderDtoArgs args);

}
