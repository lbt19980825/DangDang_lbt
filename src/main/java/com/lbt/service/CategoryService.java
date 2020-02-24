package com.lbt.service;

import java.util.List;

import com.lbt.entity.Category;

public interface CategoryService {
	//获取所有商品类别
	public List<Category> showAllCAtegory();
	//插入一级类别
	public void insertFirstCategory(Category category);
	//查询一级类别
	public List<Category> shoFirstCategory();
	//插入二级类别
	public void insertSecondCategory(Category category);
	//根据id查询其一级类别及其下面所有的二级类别，并删除
	public void queryFitstAndSecondCategory(String id);
	//查询所有一级类别及其下面所有的二级类别
	public List<Category> getCategory();
	//根据id查询所有一级类别及其下面所有的二级类别
	public Category queryFitstAndSecondCategoryById(String fid);
}
