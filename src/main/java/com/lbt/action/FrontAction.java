package com.lbt.action;

import java.util.List;

import com.lbt.entity.Book;
import com.lbt.entity.Category;
import com.lbt.entity.PageBean;
import com.lbt.service.BookService;
import com.lbt.service.BookServiceImpl;
import com.lbt.service.CartService;
import com.lbt.service.CartServiceImpl;
import com.lbt.service.CategoryService;
import com.lbt.service.CategoryServiceImpl;

public class FrontAction {
	private List<Category> categoryList;//分类展示
	private List<Book> recommendList;//编辑推荐展示
	private List<Book> hotList;//热销推荐展示
	private List<Book> createDateList;//最新上架展示
	private List<Book> saleAndCreateDateList;//新书热卖展示
	private String id;//从首页获取id，供展示展品详情的action使用    供添加购物车查询图书使用
	private Book book;//从action获取到book，供展示展品详情的页面使用
	private String fid;//一级类别id
	private String sid;//二级类别id
	private PageBean pagebean;//分页对象
	private List<Book> SecondPageBooks;//供二级页面图书展示
	private Category category;//二级页面分类展示
	private String orderType;
	private Integer count;//购物车的产品的数量
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Book> getSecondPageBooks() {
		return SecondPageBooks;
	}
	public void setSecondPageBooks(List<Book> secondPageBooks) {
		SecondPageBooks = secondPageBooks;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public PageBean getPagebean() {
		return pagebean;
	}
	public void setPagebean(PageBean pagebean) {
		this.pagebean = pagebean;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Book> getSaleAndCreateDateList() {
		return saleAndCreateDateList;
	}
	public void setSaleAndCreateDateList(List<Book> saleAndCreateDateList) {
		this.saleAndCreateDateList = saleAndCreateDateList;
	}
	public List<Book> getCreateDateList() {
		return createDateList;
	}
	public void setCreateDateList(List<Book> createDateList) {
		this.createDateList = createDateList;
	}
	public List<Book> getHotList() {
		return hotList;
	}
	public void setHotList(List<Book> hotList) {
		this.hotList = hotList;
	}
	public List<Book> getRecommendList() {
		return recommendList;
	}
	public void setRecommendList(List<Book> recommendList) {
		this.recommendList = recommendList;
	}
	public List<Category> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	//展示主页面
	public String mainAction(){
		CategoryService cs = new CategoryServiceImpl();
		//类别展示
		categoryList= cs.getCategory();
		//编辑推荐展示
		BookService bs = new BookServiceImpl();
		recommendList = bs.showTwoBook();
		//热销图书展示
		hotList = bs.getPartBook();
		//最新上架图书
		createDateList = bs.getPartBookByCreateDate();
		//新书热卖展示
		saleAndCreateDateList = bs.getPartBookBySaleAndCreateDate();
		return "showMainSuccess";
	}
	//展示图书细节
	public String showBookDetail(){
		BookService bs = new BookServiceImpl();
		book = bs.getBookById(id);
		return "showBookDetailSuccess";
	}
	//展示二级图书
	public String showSecondLevelBook(){
		BookService bs = new BookServiceImpl();
		CategoryService cs = new CategoryServiceImpl();
		Integer count = bs.getPartBookCount(fid, sid);
		pagebean.setTotalRow(count);
		pagebean.setPageRow(4);
		SecondPageBooks =  bs.getPartBookByFidAndSidAndPageBean(fid, sid, pagebean,orderType);
		category = cs.queryFitstAndSecondCategoryById(fid);
		return "showSecondLevelBookSuccess";
	}
	/*
	 *购物车模块 
	 */
	//添加购物车
	public String cartAction(){
		CartService cs = new CartServiceImpl();
		cs.cartService(id);
		return "cartSuccess";
	}
	//修改购物车
	public String updateCart(){
		CartService cs = new CartServiceImpl();
		cs.updateCartService(id, count);
		return "updateCartSuccess";
	}
	//删除购物车
	public String deleteCart(){
		CartService cs = new CartServiceImpl();
		cs.deleteCartService(id);
		return "deleteCartSuccess";
	}
	
	
	
	
}
