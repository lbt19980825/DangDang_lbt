package com.lbt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lbt.entity.User;

public interface UserDao {
	//根据邮箱查询
	public User queryUserByEmail(@Param("email")String email);
	//插入
	public void insertUser(@Param("user")User user);
	//激活用户
	public void UpdateUser(@Param("user")User user);
	//获取所有用户
	public List<User> getAllUser();
	//更改用户状态
	public void updateUser(@Param("user")User user);
}
