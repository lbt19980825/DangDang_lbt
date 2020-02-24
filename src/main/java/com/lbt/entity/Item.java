package com.lbt.entity;

import java.io.Serializable;
import java.util.Date;

public class Item implements Serializable {

	/**
	 * 对订单项进行实例化
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String book_id;
	private String order_id;
	private double count;
	private Date create_cate;
	private String name;
	private String cover;
	private double price;
	private double dprice;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public double getCount() {
		return count;
	}
	public void setCount(double count) {
		this.count = count;
	}
	public Date getCreate_cate() {
		return create_cate;
	}
	public void setCreate_cate(Date create_cate) {
		this.create_cate = create_cate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDprice() {
		return dprice;
	}
	public void setDprice(double dprice) {
		this.dprice = dprice;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(String id, String book_id, String order_id, double count,
			Date create_cate, String name, String cover, double price,
			double dprice) {
		super();
		this.id = id;
		this.book_id = book_id;
		this.order_id = order_id;
		this.count = count;
		this.create_cate = create_cate;
		this.name = name;
		this.cover = cover;
		this.price = price;
		this.dprice = dprice;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", book_id=" + book_id + ", order_id="
				+ order_id + ", count=" + count + ", create_cate="
				+ create_cate + ", name=" + name + ", cover=" + cover
				+ ", price=" + price + ", dprice=" + dprice + "]";
	}
}
