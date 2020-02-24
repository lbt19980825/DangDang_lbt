package com.lbt.service;

import org.junit.Test;

import com.lbt.dao.AdminDao;
import com.lbt.entity.Admin;
import com.lbt.util.DBUtil;


public class TestAdminService {

	@Test
	public void testAdminLogin() {
	/*	AdminService as = new AdminServiceImpl();
		Admin admin = new Admin("1","lbt","lbt");
		as.login(admin);*/
		AdminDao dao = (AdminDao) DBUtil.getDao(AdminDao.class);
		Admin a = dao.QueryByUSername("lbt");
		System.out.println(a);
		DBUtil.close();
	}

}
