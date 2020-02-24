package com.lbt.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {
	private static SqlSessionFactory factory = null;
	
	static{
		try{
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			factory = builder.build(reader);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	public static final ThreadLocal<SqlSession> tol = new ThreadLocal<SqlSession>();
	public static SqlSession openSession() throws Exception{
    	SqlSession session = tol.get();
        if( session==null ){
        	session = factory.openSession();
        	tol.set(session);
        }	
    	return session;
	}
	public static void close() {
		try {
			SqlSession session = openSession();  
			session.close();
			tol.remove();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static Object getDao(Class daoClass) {
        SqlSession session;
		try {
			session = DBUtil.openSession();
			@SuppressWarnings("unchecked")
			Object dao = session.getMapper(daoClass);
	    	return dao;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    	
	
	}
	public static void commit() throws Exception {
		
			SqlSession session = openSession();
			session.commit();
			close();
  
	}

	public static void rollback(){
		try {
			SqlSession session = openSession();
			session.rollback();
			close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	
}
