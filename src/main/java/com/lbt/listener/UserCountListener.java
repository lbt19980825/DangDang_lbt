package com.lbt.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class UserCountListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		ServletContext	application = arg0.getSession().getServletContext();
		Integer i = (Integer) application.getAttribute("count");
		if(i==null){
			i = 1;
		}else{
			i++;
		}
		application.setAttribute("count",i);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		ServletContext	application = arg0.getSession().getServletContext();
		Integer i = (Integer) application.getAttribute("count");
		if(i==null){
			i = 0;
		}else{
			i--;
		}
		application.setAttribute("count",i);

	}

}
