package com.lbt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lbt.entity.Book;
import com.lbt.entity.Category;

public interface CategoryDao {
	//查所有
	public List<Category> queryAll();
	//插入
	public void insert(@Param("category")Category category);
	//根据levels查一级类别
	public List<Category> queryFirstCategory();
	//根据id查询其一级类别及其下面所有的二级类别
	public Category queryFitstAndSecondCategory(String id);
	//根据表中的所属所属类别id查询书籍
	public List<Book> queryBookById(@Param("id")String id);
	//根据id删除
	public void deleteById(@Param("id")String id);
	//查询所有一级类别及其下面所有的二级类别
	public List<Category> queryAllCategory();
	//根据id查询其一级类别及其下面所有的二级类别
	public Category queryFitstAndSecondCategoryById(String id);
}
