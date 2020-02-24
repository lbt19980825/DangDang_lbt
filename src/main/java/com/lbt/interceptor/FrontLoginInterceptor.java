package com.lbt.interceptor;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lbt.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class FrontLoginInterceptor implements Interceptor {

	/**
	 * 对前台用户下单前是否登录和激活进行验证
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		HttpSession session=ServletActionContext.getRequest().getSession();
		User u=(User)session.getAttribute("loginUser");
		if(u==null){
			return "userlogin"; 
		}else{
			if("".equals(u.getCode())||u.getCode()==null){
				return "useractive";
			}else{
				arg0.invoke();
				return null;
			}
		}	
	}
	

	
}
