package com.ag.service.impl;

import com.ag.dao.OrderDao;
import com.ag.entity.*;
import com.ag.feign.OrderFeign;
import com.ag.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderFeign orderFeign;

    @Override
    public OrderResultDto insert(OrderDtoArgs args) {
        //设置订单属性
        OrderMaster orderMaster = new OrderMaster();
        //订单id
        String orderId = UUID.randomUUID().toString();
        orderMaster.setOrderId(orderId);
        orderMaster.setBuyerAddress(args.getAddress());
        orderMaster.setBuyerIphone(args.getPhone());
        orderMaster.setBuyerName(args.getName());
        orderMaster.setBuyerOpenid(args.getOpenid());
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());
        orderMaster.setPayStayus(11);
        orderMaster.setOrderStatus(1);



        //获取到封装对象中的id
        Double money=0.0;
        List<ItemArgsDto> items = args.getItems();
        for (ItemArgsDto item : items) {
            //设置订单项属性  订单项=遍历每一条购物项添加
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderId);
            orderDetail.setCreateTime(new Date());
            orderDetail.setUpdateTime(new Date());
            orderDetail.setDetailId(UUID.randomUUID().toString());
            //利用feign发送数据返回结果
            ProductInfo productInfo = orderFeign.toProduct(item.getProductId());
            System.out.println("service获取到的对象"+productInfo);
            //一个数据一个名字
            orderDetail.setProdcutName(productInfo.getProdcutName());
            orderDetail.setProductIcon(productInfo.getProductIcon());
            orderDetail.setProductPrice(productInfo.getProductPrice());
            orderDetail.setProductQuantity(item.getProductQuantity());
            //调用feign增删改查
            orderFeign.toProductUpdate(item.getProductQuantity(),item.getProductId() );
            //计算总价
           money += item.getProductQuantity()*productInfo.getProductPrice();
            orderDetail.setProductId(item.getProductId());
            System.out.println("-orderDetail-"+orderDetail);
            orderDao.insertOrderDetail(orderDetail);//订单项
        }


        orderMaster.setOrderAmount(money);
        orderDao.insertOrderMaster(orderMaster);

        //接口文档要求的返回结果
        OrderResultDto orderResultDto = new OrderResultDto();
        orderResultDto.setCode(0);
        orderResultDto.setMsg("成功");
        orderResultDto.setData(new OrderData(orderId));
        return orderResultDto;
    }
}
