package com.lbt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lbt.excp.AddBookExcepion;
import com.lbt.excp.AdminDeleteException;
import com.lbt.excp.AdminLoginEexception;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;



public class AdminExceptionInterceptor implements Interceptor {

	/**
	 * 对员工管理操作页面出现的异常进行拦截
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
	public String intercept(ActionInvocation arg0)   {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession(true);
		try {
			arg0.invoke();
			return null;
		}catch(AdminLoginEexception ale){ 
			String message = ale.getMessage();
			session.setAttribute("message", message);
			return "loginError";
		}catch (AddBookExcepion abe) {
			String message = abe.getMessage();
			session.setAttribute("message", message);
			return "addError";
		}catch (AdminDeleteException ade) {
			String message = ade.getMessage();
			session.setAttribute("message", message);
			return "deleteError";
		}catch(Exception e){
			return "error";
		}
		
		
		
		

	}

	

	}
