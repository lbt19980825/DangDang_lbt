package com.lbt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lbt.entity.Address;



public interface AddressDao {
	//根据用户id查所有地址
	public List<Address> getAddressByUserId(@Param("user_id")String user_id);
	//根据地址id查一条地址
	public Address getAddressById(@Param("id")String id);
	//添加地址
	public void addAddress(@Param("address")Address address);
	//修改地址
	public void updateAddress(@Param("address")Address address);
}
