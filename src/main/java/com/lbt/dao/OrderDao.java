package com.lbt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lbt.entity.Order;

public interface OrderDao {
	//插入订单数据
	public void insertOrder(@Param("order")Order order);
	//查询所有订单
	public List<Order> allOrder();
	//根据id查询订单
	public Order getOrderById(@Param("id")String id);
}
