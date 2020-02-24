package com.lbt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lbt.entity.User;

public interface UserService {
	//查找用户
	public void getUserByEmail(User user);
	//注册用户
	public void registUser(User user,String code);
	//激活用户
	public void activeUser(String activeCode);
	//获取所有用户
	public List<User> getAllUser();
	//更改用户状态
	public void updateUser(String email);
}
