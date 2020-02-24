package com.lbt.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
	/**
	 * 对订单表进行实例化
	 */
	private static final long serialVersionUID = 1L;
	private String id;//订单id
	private String order_name;//订单编号
	private double total;//总价
	private Date create_date;//创建时间
	private String address_id;//地址id
	private String user_id;//用户id
	private String name;//收件人
	private String local;//收货地址
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getAddress_id() {
		return address_id;
	}
	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String id, String order_name, double total, Date create_date,
			String address_id, String user_id, String name, String local) {
		super();
		this.id = id;
		this.order_name = order_name;
		this.total = total;
		this.create_date = create_date;
		this.address_id = address_id;
		this.user_id = user_id;
		this.name = name;
		this.local = local;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", order_name=" + order_name + ", total="
				+ total + ", create_date=" + create_date + ", address_id="
				+ address_id + ", user_id=" + user_id + ", name=" + name
				+ ", local=" + local + "]";
	}
	
}
