package com.ag.feign;

import com.ag.entity.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PRODUCT",url = "http://localhost:9001")
public interface OrderFeign {

    //利用Feign请求发送给product 返回Product对象
    @RequestMapping("product/queryProductById")
    ProductInfo toProduct(@RequestParam("id") String id);

    //利用feign发送product项目进行修改
    @RequestMapping("product/update")
    void toProductUpdate(@RequestParam("quantity") Integer quantity,@RequestParam("id") String id);

}
