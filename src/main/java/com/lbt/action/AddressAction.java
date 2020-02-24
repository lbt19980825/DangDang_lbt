package com.lbt.action;

import java.util.List;

import com.lbt.entity.Address;
import com.lbt.service.AddressService;
import com.lbt.service.AddressServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class AddressAction extends ActionSupport {

	/**
	 * 对地址模块进行功能实现
	 */
	private static final long serialVersionUID = 1L;
	private String address_id;//从地址页面获取地址id
	private List<Address> list;//供地址页面下拉列表显示用户所有地址用
	private Address address;//点击下拉列表，供展示地址用

	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}

	public List<Address> getList() {
		return list;
	}

	public void setList(List<Address> list) {
		this.list = list;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	//查询旧地址和获取旧地址
	public String getOldAddress(){
		AddressService as = new AddressServiceImpl();
		list = as.getAddressByUserId(); 
		if(address_id!=null){
			address = as.getAddressById(address_id);
		}
		return "getAddressSuccess";
	}
}
