package com.lbt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lbt.entity.Address;
import com.lbt.entity.Item;
import com.lbt.entity.Order;

public interface OrderService {
	//1.处理地址数据
	//2.订单数据入库
	//3.订单项数据入库
	//4.修改图书销量，库存
	//5.销毁购物车
	public void addOrder(Address address);
	//查询所有订单
	public List<Order> getAllOrder();
	//根据id查询订单
	public Order getOrderById(String id);
	//根据订单id查询所有订单项
	public List<Item> getAllItem(String order_id);


}
