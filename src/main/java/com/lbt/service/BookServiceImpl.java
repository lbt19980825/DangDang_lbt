package com.lbt.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.lbt.dao.BookDao;
import com.lbt.entity.Book;
import com.lbt.entity.Category;
import com.lbt.entity.PageBean;
import com.lbt.excp.AddBookExcepion;
import com.lbt.util.DBUtil;

public class BookServiceImpl implements BookService {

	@Override
	public List<Book> showAllBook() {
		//展示所有
		BookDao dao = (BookDao) DBUtil.getDao(BookDao.class);
		List<Book> list = dao.queryAllBook();
		DBUtil.close();
		return list;
	}

	@Override
	public List<Category> getAllSecondCategory() {
		BookDao dao = (BookDao) DBUtil.getDao(BookDao.class);
		List<Category> list = dao.queryAllTwoCategory();
		return list;
	}
	//添加图书
	@Override
	public void addBook(Book book) {
		
		try {
			BookDao dao = (BookDao) DBUtil.getDao(BookDao.class);
			book.setId(UUID.randomUUID().toString());//id
			book.setCreate_date(new Date());//创建时间
			book.setSale(0);//销量
			dao.insertBook(book);
			DBUtil.commit();
		} catch (AddBookExcepion abe) {
			DBUtil.rollback();
			abe.getMessage();
			// TODO Auto-generated catch block
			abe.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//根据id查找
	@Override
	public Book getBookById(String id) {
		BookDao dao = (BookDao) DBUtil.getDao(BookDao.class);
		Book book = dao.queryBookById(id);
		DBUtil.close();
		return book;
	}

	@Override
	public Category getCategoryNameById(String id) {
		BookDao dao = (BookDao) DBUtil.getDao(BookDao.class);
		Category category= dao.queryCategoryById(id);
		DBUtil.close();
		return category;
	}
	
	
	//修改图书
	@Override
	public void updateBook(Book book) {
		try {
			BookDao dao = (BookDao) DBUtil.getDao(BookDao.class);
			dao.updateBook(book);
			DBUtil.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//根据id删除图书
	@Override
	public void deleteBook(String id) {
		try {
			BookDao dao = (BookDao) DBUtil.getDao(BookDao.class);
			dao.deleteBook(id);
			DBUtil.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//根据类型很内容模糊查询
	@Override
	public List<Book> dimQueryBook(String key, String content) {
		BookDao dao = (BookDao) DBUtil.getDao(BookDao.class);
		System.out.println(key);
		System.out.println(content);
		List<Book> list = dao.dimQueryBook(key, content);
		DBUtil.close();
		return list;
	}
	//查所有图书,随机展示两个
	@Override
	public List<Book> showTwoBook() {
		BookDao dao = (BookDao) DBUtil.getDao(BookDao.class);
		List<Book> list = dao.queryAllBook();
		Integer a = new Random().nextInt(list.size());
		Integer b = new Random().nextInt(list.size());
		while(true){
			if(a==b){
				a=new Random().nextInt(list.size());
			}else{
				break;
			}
			
		}
		List<Book> list2 = new ArrayList<Book>();
		list2.add(list.get(a));
		list2.add(list.get(b));
		DBUtil.close();
		return list2;
	}
	//获取销量前八的图书
	@Override
	public List<Book> getPartBook() {
		BookDao dao = (BookDao) DBUtil.getDao(BookDao.class);
		List<Book> list = dao.queryPartBook();
		DBUtil.close();
		return list;
	}

	@Override
	public List<Book> getPartBookByCreateDate() {
		BookDao dao = (BookDao) DBUtil.getDao(BookDao.class);
		List<Book> list = dao.queryPartBookByCreateDate();
		DBUtil.close();
		return list;
	}
	//查询图书中先按销量再按最新的前八的图书
	@Override
	public List<Book> getPartBookBySaleAndCreateDate() {
		BookDao dao = (BookDao) DBUtil.getDao(BookDao.class);
		List<Book> list = dao.queryPartBookBySaleAndCreateDate();
		DBUtil.close();
		return list;
	}
	
	
	//根据id的不同查找不同类型的图书,并分页
	@Override
	public List<Book> getPartBookByFidAndSidAndPageBean(String fid, String sid,
			PageBean pagebean,String orderType) {
		BookDao dao = (BookDao) DBUtil.getDao(BookDao.class);
		List<Book> list = dao.queryPartBookByFifAndSidAndPageBean(fid, sid, pagebean,orderType);
		DBUtil.close();
		return list;
	}
	
	
	//根据id的不同查找不同类型的图书的数量
	@Override
	public Integer getPartBookCount(String fid, String sid) {
		BookDao dao = (BookDao) DBUtil.getDao(BookDao.class);
		Integer count = dao.queryPartBookCount(fid, sid);
		return count;
	}

}
