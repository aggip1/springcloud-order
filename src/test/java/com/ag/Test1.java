package com.ag;

import com.ag.entity.ProductInfo;
import com.ag.feign.OrderFeign;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Test1 {
    @Autowired
    private OrderFeign orderFeign;
    @Test
    public void test5() {
        ProductInfo productInfo = orderFeign.toProduct("123456");
        System.out.println(productInfo);

    }
}
