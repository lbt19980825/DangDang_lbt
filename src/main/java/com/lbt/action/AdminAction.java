package com.lbt.action;

import java.awt.image.BufferedImage;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lbt.entity.Admin;
import com.lbt.entity.Category;
import com.lbt.excp.AdminLoginEexception;
import com.lbt.service.AdminService;
import com.lbt.service.AdminServiceImpl;
import com.lbt.service.CategoryService;
import com.lbt.service.CategoryServiceImpl;
import com.lbt.util.SecurityCode;
import com.lbt.util.SecurityImage;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {
	/**
	 * 后台登录系统，实现登录功能，获取验证码功能，安全退出功能
	 *             类别模块： 展示类别功能，
	 */
	private static final long serialVersionUID = 1L;
	private String fname;//收添加一级类别的name
	private List<Category> categoryList;//获取所有类别,供展示类别的页面使用      //获取所有一级类别，供添加二级类别的下拉列表使用
	private Admin admin;//接收登录信息
	private String code;//获取从登录页面收到的验证码参数
	private Category cate;//收添加二级类别的参数
	private String id;//收删除功能的id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Category getCate() {
		return cate;
	}

	public void setCate(Category cate) {
		this.cate = cate;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	
	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}


	
	public void setCode(String code) {
		this.code = code;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	//实现登录功能（用户名密码）
	public String login(){
		    AdminService as = new AdminServiceImpl();
			HttpSession session=ServletActionContext.getRequest().getSession();
			session.setAttribute("login", "login");//设置登录标记
			String code1 = (String) session.getAttribute("code");//获取生成的验证码
			if(!code1.equals(code))throw new AdminLoginEexception("验证码输入错误");//生成的验证码与输入验证码对比
			as.login(admin);
			return "loginSuccess";
	} 
	//获取验证码
	public String getCode(){
		String code=SecurityCode.getSecurityCode();//使用工具类生成验证码内容
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("code", code);//为验证码设置一个作用域，供登录验证时使用
		BufferedImage image=SecurityImage.createImage(code);//使用工具类生成验证码图片
		ServletOutputStream stream=null;
		try {
			stream=ServletActionContext.getResponse().getOutputStream();
			ImageIO.write(image, "png", stream);//输出
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	//安全退出
	public String exit(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.invalidate();
		return "exitSuccess";
	}
	
/*
 *类别模块 
 */
	//展示类别功能   
	public String showCategory(){
		CategoryService cs = new CategoryServiceImpl();
		categoryList = cs.showAllCAtegory();//获取所有类别
		return "showSuccess";
	}
	//插入一级类别功能
	public String addFirstCategory(){
		CategoryService cs = new CategoryServiceImpl();
		String id = UUID.randomUUID().toString();
		Category category = new Category(id,fname,null,"1",null,null);
		cs.insertFirstCategory(category); 
		return "addSuccess";
	}
	//查询所有一级类别功能
	public String queryFirstCategory(){
		CategoryService cs = new CategoryServiceImpl();
		categoryList = cs.shoFirstCategory();
		return "queryFirstSuccess";
	}
	//插入二级类别功能
	public String addSecondCategory(){
		CategoryService cs = new CategoryServiceImpl();
		String id = UUID.randomUUID().toString();
		cate.setId(id);
		cate.setLevels("2");
		cs.insertSecondCategory(cate);
		return "addSecondSuccess";
	} 
	//删除类别功能
	public String deleteCategory(){
			CategoryService cs = new CategoryServiceImpl();
			cs.queryFitstAndSecondCategory(id);
			return "deleteSuccess";

	}
	
	
}
