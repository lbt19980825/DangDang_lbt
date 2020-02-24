package com.lbt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lbt.entity.Item;

public interface ItemDao {
	//插入订单项
	public void insertItem(@Param("item")Item item); 
	//根据订单id查询所有订单项
	public List<Item> getAllItem(@Param("order_id")String order_id);
}
