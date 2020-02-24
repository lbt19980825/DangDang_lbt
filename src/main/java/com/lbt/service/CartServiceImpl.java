package com.lbt.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lbt.dao.BookDao;
import com.lbt.entity.Book;
import com.lbt.entity.CartItem;
import com.lbt.util.DBUtil;

public class CartServiceImpl implements CartService {

	@Override
	public void cartService(String id) {
		
		//根据id查询到该图书的信息
		BookDao dao = (BookDao) DBUtil.getDao(BookDao.class);
 		Book book = dao.queryBookById(id);
 		//判断是否是第一次购买商品，是则创建购物车，反之继续使用
 		HttpSession session = ServletActionContext.getRequest().getSession(true);
 		@SuppressWarnings("unchecked")
		Map<String,CartItem> map = (Map<String, CartItem>) session.getAttribute("cart");//获取session
 		CartItem cartItem = null;
 		double save = 0.0;
 		double total = 0.0;
 		if(map==null){
 			//第一次购买，创建购物车
 			map =new HashMap<String,CartItem>();
 			cartItem = new CartItem();
 			cartItem.setBook(book);  //图书
 			cartItem.setCount(1);   //数量
 			save = book.getPrice()-book.getDprice();//节省金额
 			total = book.getDprice();
 		}else{
 			//判断是否已购买过同类型图书,是则在原有基础上数量加一，反之则创建
 			save = (double) session.getAttribute("save");
 			total = (double) session.getAttribute("total");
 			if(map.containsKey(id)){
 				cartItem = map.get(id);
 				cartItem.setCount(cartItem.getCount()+1);
 				
 			}else{
 				cartItem = new CartItem();
 				cartItem.setBook(book);  //图书
 	 			cartItem.setCount(1);   //数量
 			}
 			save = save+(book.getPrice()-book.getDprice());
 			total = total+book.getDprice();
 		}
 		map.put(id, cartItem);
 		session.setAttribute("cart", map);
 		session.setAttribute("save", save);
 		session.setAttribute("total", total);
	}
	//修改数量
	@Override
	public void updateCartService(String id,Integer count) {
		//根据id查询到该图书的信息
		BookDao dao = (BookDao) DBUtil.getDao(BookDao.class);
 		Book book = dao.queryBookById(id);
 		HttpSession session = ServletActionContext.getRequest().getSession(true);
		@SuppressWarnings("unchecked")
		Map<String,CartItem> map = (Map<String, CartItem>) session.getAttribute("cart");
		double save = (double) session.getAttribute("save");
		double total = (double) session.getAttribute("total");
		CartItem cartItem = map.get(id);
		Integer oldCount = cartItem.getCount();
		cartItem.setCount(count);
		map.put(id,cartItem);
		save = save-(oldCount*(book.getPrice()-book.getDprice()));
		save = save+(count*(book.getPrice()-book.getDprice()));
		total = total-(oldCount*book.getDprice());
		total = total+(count*book.getDprice());
		session.setAttribute("cart", map);
		session.setAttribute("save", save);
		session.setAttribute("total", total);
	}
	//删除
	@Override
	public void deleteCartService(String id) {
		//根据id查询到该图书的信息
		BookDao dao = (BookDao) DBUtil.getDao(BookDao.class);
 		Book book = dao.queryBookById(id);
 		HttpSession session = ServletActionContext.getRequest().getSession(true);
		@SuppressWarnings("unchecked")
		Map<String,CartItem> map = (Map<String, CartItem>) session.getAttribute("cart");
		double save = (double) session.getAttribute("save");
		double total = (double) session.getAttribute("total");
		CartItem cartItem = map.get(id);
		Integer oldCount = cartItem.getCount();
		map.remove(id);
		save = save-(oldCount*(book.getPrice()-book.getDprice()));
		total = total-(oldCount*book.getDprice());
		if(map.size()==0){
			session.removeAttribute("cart");
			session.removeAttribute("save");
			session.removeAttribute("tatal");
		}else{
			session.setAttribute("cart", map);
			session.setAttribute("save", save);
			session.setAttribute("total", total);
		}
		
	}

}
