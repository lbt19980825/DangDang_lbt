package com.lbt.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lbt.dao.AddressDao;
import com.lbt.dao.BookDao;
import com.lbt.dao.ItemDao;
import com.lbt.dao.OrderDao;
import com.lbt.entity.Address;
import com.lbt.entity.Book;
import com.lbt.entity.CartItem;
import com.lbt.entity.Item;
import com.lbt.entity.Order;
import com.lbt.entity.User;
import com.lbt.util.DBUtil;

public class OrderServiceImpl implements OrderService {
	//1.处理地址数据
	//2.订单数据入库
	//3.订单项数据入库
	//4.修改图书销量，库存
	//5.销毁购物车
	@Override
	public void addOrder(Address address) {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		AddressDao dao = (AddressDao) DBUtil.getDao(AddressDao.class);
		ItemDao itemDao = (ItemDao) DBUtil.getDao(ItemDao.class);
		OrderDao orderDao = (OrderDao) DBUtil.getDao(OrderDao.class);
		BookDao bookDao = (BookDao) DBUtil.getDao(BookDao.class);
		//获取user的session
		User user = (User) session.getAttribute("loginUser");
		//获取总价的session
		double total = (double) session.getAttribute("total");
		//获取购物车的session
		@SuppressWarnings("unchecked")
		Map<String,CartItem> map = (Map<String, CartItem>) session.getAttribute("cart");
		try {
			//1.处理地址数据，判断是否为新地址
			if(address.getId().equals("")||address.getId()==null){
				//新地址
				address.setId(UUID.randomUUID().toString());
				address.setUser_id(user.getId());
				
				dao.addAddress(address);
			}else{
				//旧地址,判断其是否进行了修改
				Address addr= dao.getAddressById(address.getId());
				if(!address.equals(addr)){
					dao.updateAddress(address);
				}
			}
			//2.处理订单数据
			Order order = new Order();
			order.setId(UUID.randomUUID().toString());
			order.setOrder_name((new Date()).getTime()+"");
			order.setTotal(total);
			order.setCreate_date(new Date());
			order.setAddress_id(address.getId());
			order.setUser_id(user.getId());
			order.setName(address.getName());
			order.setLocal(address.getLocal());
			orderDao.insertOrder(order);
			//将订单插入数据库
			
			//3.处理订单项数据
			Set<String> set = map.keySet();//键遍历
			for (String id : set) {
				CartItem cartItem = map.get(id);
				Item item = new Item();
				item.setId(UUID.randomUUID().toString());
				item.setBook_id(cartItem.getBook().getId());
				item.setOrder_id(order.getId());
				item.setCount(cartItem.getCount());
				item.setCreate_cate(new Date());
				item.setName(cartItem.getBook().getName());
				item.setCover(cartItem.getBook().getCover());
				item.setPrice(cartItem.getBook().getPrice());
				item.setDprice(cartItem.getBook().getDprice());
				//将订单项插入数据库
				itemDao.insertItem(item);
				//4.修改图书销量，库存
				Book book = cartItem.getBook();
				book.setSale(book.getSale()+cartItem.getCount());
				book.setStock(book.getStock()-cartItem.getCount());		
				bookDao.updateBook(book);
			}
			DBUtil.commit();
			//销毁购物车
			session.removeAttribute("cart");
			session.setAttribute("order_name", order.getOrder_name());
			DBUtil.commit();
		} catch (Exception e) {
			DBUtil.rollback();
			e.printStackTrace();
		}
	}
	//查询所有订单
	@Override
	public List<Order> getAllOrder() {
		OrderDao dao = (OrderDao) DBUtil.getDao(OrderDao.class);
		List<Order> list = dao.allOrder();
		DBUtil.close();
		return list;
	}
	
	//根据id查询订单
	@Override
	public Order getOrderById(String id) {
		OrderDao dao = (OrderDao) DBUtil.getDao(OrderDao.class);
		Order order = dao.getOrderById(id);
		DBUtil.close();
		return order;
	}
	
	//根据订单id查询所有订单项
	@Override
	public List<Item> getAllItem(String order_id) {
		ItemDao dao = (ItemDao) DBUtil.getDao(ItemDao.class);
		List<Item> list = dao.getAllItem(order_id);
		DBUtil.close();
		return list;
	}

}
