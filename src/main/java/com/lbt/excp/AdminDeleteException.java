package com.lbt.excp;

public class AdminDeleteException extends RuntimeException {
	/**
	 * 自定义后台管理员删除异常
	 */
	private static final long serialVersionUID = 1L;

	public AdminDeleteException(String message){
		super(message);
	}
}
