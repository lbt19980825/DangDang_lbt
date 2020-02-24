package com.lbt.service;

import java.util.List;

import org.junit.Test;

import com.lbt.dao.CategoryDao;
import com.lbt.entity.Category;
import com.lbt.util.DBUtil;

public class TestCategoryService {

	@Test
	public void test() {
		CategoryService cs = new CategoryServiceImpl();
		List<Category> list = cs.showAllCAtegory();
		System.out.println(list);
	}
	@Test
	
	public void queryFitstAndSecondCategory() {
/*		CategoryDao dao = (CategoryDao)DBUtil.getDao(CategoryDao.class);
		List<Book> list = dao.queryBookById("e3a61c36-ab29-4e92-aeeb-dd67a48d38d1");
		System.out.println(list.size());*/
/*		BookService bs = new BookServiceImpl();
		Book book = bs.getBookById("89e8264d-7113-4013-9768-0a92b59ed96c");
		System.out.println(book);*/
		//BookService bs = new BookServiceImpl();
	/*	Category name = bs.getCategoryNameById("f0dbdcb6-1857-4063-8759-090265c217c3");
		System.out.println(name);*/
		CategoryService cs = new CategoryServiceImpl();
		List<Category> list = cs.getCategory();
		System.out.println(list);
	/*	CategoryDao dao = (CategoryDao)DBUtil.getDao(CategoryDao.class);
		List<Category> list = dao.queryAllCategory();
		System.out.println(list);
		DBUtil.close();*/
		
	}

}
