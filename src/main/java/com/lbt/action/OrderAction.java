package com.lbt.action;

import java.util.List;

import com.lbt.entity.Address;
import com.lbt.entity.Item;
import com.lbt.entity.Order;
import com.lbt.service.OrderService;
import com.lbt.service.OrderServiceImpl;

public class OrderAction {

	/**
	 * 对订单实现功能
	 */

	private Address address;
	private List<Order> list;
	private Order order;
	private List<Item> itemlist;
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<Item> getItemlist() {
		return itemlist;
	}
	public void setItemlist(List<Item> itemlist) {
		this.itemlist = itemlist;
	}
	public List<Order> getList() {
		return list;
	}
	public void setList(List<Order> list) {
		this.list = list;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String addOrder(){
		OrderService os = new OrderServiceImpl();
		os.addOrder(address);
		return "addOrderSuccess";
	}
	//展示所有订单
	public String AllOrder(){
		OrderService os = new OrderServiceImpl();
		list = os.getAllOrder();
		return "AllOrderSuccess";
	}
	//获取该订单详细信息
	public String detailInform(){
		OrderService os = new OrderServiceImpl();
		order = os.getOrderById(id);
		itemlist = os.getAllItem(id);
		return "detailInformSuccess";
	}

}
