package com.lbt.service;

import java.util.List;

import com.lbt.dao.CategoryDao;
import com.lbt.entity.Book;
import com.lbt.entity.Category;
import com.lbt.excp.AdminDeleteException;
import com.lbt.util.DBUtil;

public class CategoryServiceImpl implements CategoryService {

	@Override
	//展示所有
	public List<Category> showAllCAtegory() {
		CategoryDao dao = (CategoryDao)DBUtil.getDao(CategoryDao.class);
		List<Category> list = dao.queryAll();
		DBUtil.close();
		return list;
	}
	//插入一级类别
	@Override
	public void insertFirstCategory(Category category) {
		try {
			if(!category.getName().equals("")){	
				CategoryDao dao = (CategoryDao)DBUtil.getDao(CategoryDao.class);
				dao.insert(category);
				DBUtil.commit();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//查询所有一级类别
	@Override
	public List<Category> shoFirstCategory() {
		CategoryDao dao = (CategoryDao)DBUtil.getDao(CategoryDao.class);
		List<Category> list = dao.queryFirstCategory();
		DBUtil.close();
		return list;
	}
	//插入二级列表
	@Override
	public void insertSecondCategory(Category category) {
		try {
			if(!category.getName().equals("")){	
				CategoryDao dao = (CategoryDao)DBUtil.getDao(CategoryDao.class);
				dao.insert(category);
				DBUtil.commit();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	//获取一级类别及其下面所有的二级类别
	@Override
	public void queryFitstAndSecondCategory(String id) {
		try{
			CategoryDao dao = (CategoryDao)DBUtil.getDao(CategoryDao.class);
			//判断id时一级还是二级类别
			Category cate  = dao.queryFitstAndSecondCategory(id);
			if(cate!=null){
				//此时是一级类别，判断是否有二级类别
				if(cate.getCategory()==null){
					dao.deleteById(id);
				}else{
					throw new AdminDeleteException("此一级类别下还有二级类别！");
				}
			}else{
				//此时是二级类别，判断是否图书
				List<Book> list = dao.queryBookById(id);
				if(list.size()==0){
					dao.deleteById(id);
				}else{
					throw new AdminDeleteException("此二级类别下还有图书！");
				}
			}
			DBUtil.commit();
		}catch (Exception e) {
			throw new AdminDeleteException(e.getMessage());

		}	
	}
	//查询所有一级类别及其下面所有的二级类别
	@Override
	public List<Category> getCategory() {
		CategoryDao dao= (CategoryDao) DBUtil.getDao(CategoryDao.class);
		List<Category> list = dao.queryAllCategory();
		DBUtil.close();
		return list;
	}
	@Override
	public Category queryFitstAndSecondCategoryById(String fid) {
		CategoryDao dao= (CategoryDao) DBUtil.getDao(CategoryDao.class);
		Category category = dao.queryFitstAndSecondCategoryById(fid);
		DBUtil.close();
		return category;
	}
	



}
