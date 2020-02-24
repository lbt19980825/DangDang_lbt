package com.lbt.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lbt.dao.UserDao;
import com.lbt.entity.User;
import com.lbt.util.DBUtil;
import com.lbt.util.MD5Utils;

public class UserServiceImpl implements UserService {
	
	
	//查找
	@Override
	public void getUserByEmail(User user) {
		UserDao dao = (UserDao) DBUtil.getDao(UserDao.class);
		User user1 = dao.queryUserByEmail(user.getEmail());
		if(user1==null) throw new RuntimeException("此邮箱不存在！！");
		String pass = user.getPassword()+user1.getSalt();
		String password = MD5Utils.getPassword(pass);
		if(!password.equals(user1.getPassword()))throw new RuntimeException("密码错误！！");
		if(user1.getStatus().equals("冻结"))throw new RuntimeException("当前用户已被冻结！！");
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		session.setAttribute("loginUser", user1);
		DBUtil.close();
	}
	//注册用户
	@Override
	public void registUser(User user,String code) {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		String code1 = (String) session.getAttribute("code");
		if(!code1.equals(code))throw new RuntimeException("验证码错误！！！");
		UserDao dao = (UserDao) DBUtil.getDao(UserDao.class);
		User user1 = dao.queryUserByEmail(user.getEmail());
		if(user1!=null) throw new RuntimeException("该邮箱已被注册！！！");
		try {
			//补全字段
			user.setId(UUID.randomUUID().toString());
			user.setStatus("正常");
			user.setCreate_date(new Date());
			String salt = MD5Utils.getSalt();
			String password = MD5Utils.getPassword(user.getPassword()+salt);
			user.setSalt(salt);
			user.setPassword(password);
			dao.insertUser(user);
			session.setAttribute("loginUser", user);
			DBUtil.commit();
		} catch (Exception e) {
			DBUtil.rollback();
			e.printStackTrace();
		}
	}
	
	
	//激活用户
	@Override
	public void activeUser(String activeCode) {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		String code = (String) session.getAttribute("activeCode");
		if(!code.equals(activeCode)) throw new RuntimeException("激活码输入错误!!");
		User user = (User) session.getAttribute("loginUser");
		user.setCode(activeCode);
		session.setAttribute("loginUser", user);
		try {
			UserDao dao = (UserDao) DBUtil.getDao(UserDao.class);
			dao.UpdateUser(user);
			DBUtil.commit();
		} catch (Exception e) {
			DBUtil.rollback();			
			e.printStackTrace();
		}
	}
	
	//获取所有用户
	@Override
	public List<User> getAllUser() {
		UserDao dao = (UserDao) DBUtil.getDao(UserDao.class);
		List<User> user = dao.getAllUser();
		DBUtil.close();
		return user;
	}
	
	//更改用户状态
	@Override
	public void updateUser(String email) {
		UserDao dao = (UserDao) DBUtil.getDao(UserDao.class);
		User user = dao.queryUserByEmail(email);
		if(user.getStatus().equals("正常")){
			user.setStatus("冻结");
		}else{
			user.setStatus("正常");
		}
		try {
			dao.updateUser(user);
			DBUtil.commit();
		} catch (Exception e) {
			DBUtil.rollback();
			e.printStackTrace();
		}
	}
	

}
