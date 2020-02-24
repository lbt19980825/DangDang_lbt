package com.lbt.service;

import java.util.List;

import com.lbt.entity.Book;
import com.lbt.entity.Category;
import com.lbt.entity.PageBean;

public interface BookService {
	//查所有图书
	public List<Book> showAllBook();
	//查所有一级类别
	public List<Category> getAllSecondCategory();
	//添加图书
	public void addBook(Book book);
	//按照id查找当前图书
	public Book getBookById(String id);
	//按照id查找当前类别名
	public Category getCategoryNameById(String id);
	//修改图书
	public void updateBook(Book book);
	//根据id删除图书
	public void deleteBook(String id);
	//根据类型很内容模糊查询
	public List<Book> dimQueryBook(String key,String content);
	//查所有图书,随机展示两个
	public List<Book> showTwoBook();
	//获取销量前八的图书
	public List<Book> getPartBook();
	//查询图书中最新的前八的图书
	public List<Book> getPartBookByCreateDate();
	//查询图书中先按销量再按最新的前八的图书
	public List<Book> getPartBookBySaleAndCreateDate();
	//根据id的不同查找不同类型的图书,并分页
	public List<Book> getPartBookByFidAndSidAndPageBean(String fid,String sid,PageBean pagebean,String orderType);
	//根据id的不同查找不同类型的图书的数量
	public Integer getPartBookCount(String fid,String sid);

}
