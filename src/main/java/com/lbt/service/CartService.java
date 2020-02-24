package com.lbt.service;

public interface CartService {
	//对购物车模块进行事务控制
	//添加
	public void cartService(String id);
	//修改
	public void updateCartService(String id,Integer count);
	//删除
	public void deleteCartService(String id);
}
