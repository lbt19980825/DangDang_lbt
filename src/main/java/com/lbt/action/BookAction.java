package com.lbt.action;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.lbt.entity.Book;
import com.lbt.entity.Category;
import com.lbt.excp.AddBookExcepion;
import com.lbt.service.BookService;
import com.lbt.service.BookServiceImpl;
import com.lbt.util.DBUtil;
import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {

	/**
	 * 对图书模块进行功能实现
	 */
	private static final long serialVersionUID = 1L;
	private List<Book> bookList;//存储所有图书，供展示图书页面使用
	private List<Category> firstCategoryList;//存储所有二级类别，供添加图书和修改图书的展示的下拉列表使用
	private Book book;//根据图书id查到的图书，供给修改图书的页面显示默认图书使用
	private File cover;
	private String coverFileName;
	private String coverContextType;
	private String id;//根据id查找当前图书信息
	private Category category;//获取当前类别名字供展示
	private String key;//获取模糊查询的key
	private String content;//获取模糊查询的内容

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public File getCover() {
		return cover;
	}

	public void setCover(File cover) {
		this.cover = cover;
	}

	public String getCoverFileName() {
		return coverFileName;
	}

	public void setCoverFileName(String coverFileName) {
		this.coverFileName = coverFileName;
	}

	public String getCoverContextType() {
		return coverContextType;
	}

	public void setCoverContextType(String coverContextType) {
		this.coverContextType = coverContextType;
	}

	public List<Category> getFirstCategoryList() {
		return firstCategoryList;
	}

	public void setFirstCategoryList(List<Category> firstCategoryList) {
		this.firstCategoryList = firstCategoryList;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	//展示所有图书功能
	public String showAllBook(){
		BookService bs = new BookServiceImpl();
		bookList = bs.showAllBook();//调service方法查所有图书
		return "showBookSuccess";
	}
	
	//获取所有二级类别
	public String GetSecondCategory(){
		BookService bs = new BookServiceImpl();
		firstCategoryList = bs.getAllSecondCategory();//调service方法查所有一级类别
		return "getSuccess";
	}
	//添加图书功能
	public String addBook() throws Exception {
		BookService bs =null;
			if(cover==null) throw new AddBookExcepion("请补全图书");//如果从页面收到的图片为空，则抛出添加图书异常
			bs = new BookServiceImpl();
			String path = ServletActionContext.getServletContext().getRealPath("/com/lbt/back/images");//根据相对路径获取绝对路径
			FileUtils.copyFile(cover, new File(path,coverFileName));//使用工具类进行文件拷贝
			//为从页面获取的图书补全封面,创建日期属性
			book.setCover(coverFileName);
			book.setCreate_date(new Date());
			bs.addBook(book);
			DBUtil.commit(); 
			return "addBookSuccess";
	}
	//获取当前图书内容和所有二级类别供给下拉列表
	public String getCurrentBook(){
		BookService bs = new BookServiceImpl();
		book= bs.getBookById(id);//根据id获取图书
		firstCategoryList = bs.getAllSecondCategory();//获取所有二级类别
		category = bs.getCategoryNameById(book.getCategory_id());
		return "getBookSuccess";
	}
	//删除图书
	public String deleteBook(){
		BookService bs = new BookServiceImpl();
		bs.deleteBook(id);
		return "deleteSuccess";
	}
	//按条件查询
	public String dimQuery(){
		BookService bs = new BookServiceImpl();
		bookList = bs.dimQueryBook(key, content);
		return "dimSuccess";
	}
	
	//修改图书
	public String updateBook(){
		BookService	bs =null;
		try {
			bs = new BookServiceImpl();
			if(cover!=null){
				String path = ServletActionContext.getServletContext().getRealPath("/com/lbt/back/images");
				FileUtils.copyFile(cover, new File(path,coverFileName));
				book.setCover(coverFileName);
			}
			bs.updateBook(book);
			DBUtil.commit();
			return "updateSuccess";
		} catch (Exception e) {
			DBUtil.rollback();
			e.printStackTrace();
			return "updateError";
		}
	}
	
}
