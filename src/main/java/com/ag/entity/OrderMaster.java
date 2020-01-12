package com.ag.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderMaster implements Serializable {

  private String orderId;
  private String buyerName;
  private String buyerIphone;
  private String buyerAddress;
  private String buyerOpenid;
  private double orderAmount;
  private long orderStatus;
  private long payStayus;
  private Date createTime;
  private Date updateTime;


}
