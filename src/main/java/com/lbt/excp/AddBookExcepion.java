package com.lbt.excp;

import java.io.IOException;

public class AddBookExcepion extends IOException {

	/**
	 * 对添加图书自定义异常
	 */
	private static final long serialVersionUID = 1L;
	public AddBookExcepion(String message){
		super(message);
	}
}
