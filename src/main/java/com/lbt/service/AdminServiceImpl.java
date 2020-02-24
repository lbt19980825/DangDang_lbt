package com.lbt.service;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lbt.dao.AdminDao;
import com.lbt.entity.Admin;
import com.lbt.excp.AdminLoginEexception;
import com.lbt.util.DBUtil;

public class AdminServiceImpl implements AdminService {

	@Override
	public void login(Admin admin) {
			AdminDao dao =(AdminDao) DBUtil.getDao(AdminDao.class);
			Admin admin1 = dao.QueryByUSername(admin.getUsername());
			if(admin1==null) throw new AdminLoginEexception("该管理员用户不存在！");
			if(!admin1.getPassword().equals(admin.getPassword())) throw new AdminLoginEexception("用户名密码错误！");
			HttpSession session = ServletActionContext.getRequest().getSession(true);
			session.setAttribute("admin1", admin1.getUsername());
			DBUtil.close();
	}

}
