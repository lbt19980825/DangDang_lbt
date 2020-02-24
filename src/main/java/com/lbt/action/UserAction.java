package com.lbt.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lbt.entity.User;
import com.lbt.service.UserService;
import com.lbt.service.UserServiceImpl;
import com.lbt.util.MD5Utils;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	/**
	 * 对前台用户模块功能进行实现
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private String message;
	private String code;
	private String activeCode;
	private List<User> list;//查询所有用户的list
	private String email;//从展示所有用户页面收取email属性，供更改状态action使用
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public String getActiveCode() {
		return activeCode;
	}
	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	//实现登录功能
	public String loginUser(){
		try {
			UserService us = new UserServiceImpl();
			us.getUserByEmail(user);
			return "loginUserSuccess";
		} catch (Exception e) {
			message = e.getMessage();
			e.printStackTrace();
			return "loginUserError";
		}
	}
	
	//实现注册功能
	public String registUser(){
		try {
			UserService us = new UserServiceImpl();
			us.registUser(user, code);
			return "registUserSuccess";
		} catch (Exception e) {
			message = e.getMessage();
			e.printStackTrace();
			return "registUserError";
		}
	}
	//获取激活码
	public String activeCode(){
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		activeCode = MD5Utils.getNum();
		session.setAttribute("activeCode", activeCode);
		return "activeCodeSuccess";
	}
	
	//激活用户
	public String activeUser(){
		
		UserService us = new UserServiceImpl();
		try {
			us.activeUser(activeCode);
			return "activeUserSuccess";
		} catch (Exception e) {
			String message = e.getMessage();
			HttpSession session = ServletActionContext.getRequest().getSession(true);
			session.setAttribute("mess", message);
			e.printStackTrace();
			return "activeUserError";
		}
	}
	//安全退出
	public String userExit(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.invalidate();
		return "userExitSuccess";
	}
	//获取所有用户
	public String getAllUser(){
		UserService us = new UserServiceImpl();
		list = us.getAllUser();
		return "getAllUserSuccess";
	}
	//更改用户状态
	public String updateUserStatus(){
		UserService us = new UserServiceImpl();
		us.updateUser(email);
		return "updateUserStatusSuccess";
	}
}
