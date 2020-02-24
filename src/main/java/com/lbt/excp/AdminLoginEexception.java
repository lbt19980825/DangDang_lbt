package com.lbt.excp;

public class AdminLoginEexception extends RuntimeException {
	/**
	 * 自定义后台管理员登录异常
	 */
	private static final long serialVersionUID = 1L;

	public AdminLoginEexception(String message){
		super(message);
	}
}
