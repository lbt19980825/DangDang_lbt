package com.lbt.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lbt.dao.AddressDao;
import com.lbt.entity.Address;
import com.lbt.entity.User;
import com.lbt.util.DBUtil;

public class AddressServiceImpl implements AddressService {
	//根据登陆的用户进行查找其所有的地址
	@Override
	public List<Address> getAddressByUserId() {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		User user = (User) session.getAttribute("loginUser");
		AddressDao dao = (AddressDao) DBUtil.getDao(AddressDao.class);
		List<Address> list = dao.getAddressByUserId(user.getId());
		DBUtil.close();
		return list;
	}
	//根据地址id查询到该改地址的信息
	@Override
	public Address getAddressById(String id) {
		AddressDao dao = (AddressDao) DBUtil.getDao(AddressDao.class);
		Address address = dao.getAddressById(id);
		DBUtil.close();
		return address;
		
	}

}
