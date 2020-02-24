package com.lbt.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	/**
	 * 对用户表进行实例化
	 */
	private static final long serialVersionUID = 1L;
	private String id;//用户
	private String nickname;//昵称
	private String email;//邮箱
	private String password;//密码
	private String status;//状态
	private String code;//激活码
	private Date create_date;//注册时间
	private String salt ;//盐
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String nickname, String email, String password,
			String status, String code, Date create_date, String salt) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.status = status;
		this.code = code;
		this.create_date = create_date;
		this.salt = salt;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nickname=" + nickname + ", email=" + email
				+ ", password=" + password + ", status=" + status + ", code="
				+ code + ", create_date=" + create_date + ", salt=" + salt
				+ "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}

	
}
