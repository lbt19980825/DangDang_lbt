package com.lbt.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lbt.entity.Address;

public interface AddressService {
	//根据用户id查所有地址
	public List<Address> getAddressByUserId();
	//根据地址id查一条地址
	public Address getAddressById(@Param("id")String id);
}
