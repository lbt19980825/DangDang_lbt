package com.lbt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lbt.entity.Book;
import com.lbt.entity.Category;
import com.lbt.entity.PageBean;

public interface BookDao {
	//查所有图书
	public List<Book> queryAllBook();
	//查所有二级类别
	public List<Category> queryAllTwoCategory();
	//插入图书
	public void insertBook(Book book);
	//按id查图书
	public Book queryBookById(@Param("id")String id);
	//根据id查找当前二级类别名字
	public Category queryCategoryById(@Param("id")String id);
	//修改图书
	public void updateBook(Book book); 
	//根据id删除图书
	public void deleteBook(@Param("id")String id);
	//根据类型很内容模糊查询
	public List<Book> dimQueryBook(@Param("key")String key,@Param("content")String content);
	//查询图书中销量前八的图书
	public List<Book> queryPartBook();
	//查询图书中最新的前八的图书
	public List<Book> queryPartBookByCreateDate();
	//查询图书中先按销量再按最新的前八的图书
	public List<Book> queryPartBookBySaleAndCreateDate();
	//根据id的不同查找不同类型的图书,并分页
	public List<Book> queryPartBookByFifAndSidAndPageBean(@Param("fid")String fid,@Param("sid")String sid,@Param("pagebean")PageBean pagebean,@Param("orderType")String orderType);
	//根据id的不同查找不同类型的图书的数量
	public Integer queryPartBookCount(@Param("fid")String fid,@Param("sid")String sid);
}
