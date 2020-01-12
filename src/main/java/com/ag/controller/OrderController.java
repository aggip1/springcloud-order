package com.ag.controller;

import com.ag.entity.OrderDtoArgs;
import com.ag.entity.OrderResultDto;
import com.ag.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("create")
    public OrderResultDto create(@RequestBody OrderDtoArgs args){
        //接收到参数
        OrderResultDto insert = orderService.insert(args);
        return insert;
    }

}
