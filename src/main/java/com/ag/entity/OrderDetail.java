package com.ag.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetail implements Serializable {

  private String detailId;
  private String orderId;
  private String productId;
  private String prodcutName;
  private double productPrice;
  private String productIcon;
  private long productQuantity;
  private Date createTime;
  private Date updateTime;


}
