package com.lbt.dao;

import org.apache.ibatis.annotations.Param;

import com.lbt.entity.Admin;

public interface AdminDao {
	//根据姓名查
	/**
	 * 后台管理员登录
	 * @param username  用户名
	 * @return  返回admin对象
	 */
	public Admin QueryByUSername(@Param("username")String username);
}
