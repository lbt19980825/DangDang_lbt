package com.lbt.entity;

import java.io.Serializable;

public class CartItem implements Serializable {

	/**
	 * 对购物信息进行实例化
	 */
	private static final long serialVersionUID = 1L;
	private Book book;
	private Integer count;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public CartItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartItem(Book book, Integer count) {
		super();
		this.book = book;
		this.count = count;
	}
	@Override
	public String toString() {
		return "CartItem [book=" + book + ", count=" + count + "]";
	}

	
	
	
}
