package com.lbt.entity;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
	/**
	 * 对图书表进行实例化
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String author;
	private String category_id;
	private String cover;
	private String edition;
	private Date press_date;
	private String press;
	private Date print_date;
	private String impression;
	private String isbn;
	private String word_num;
	private String page_num;
	private String sizes;
	private String paper;
	private double price;
	private double dprice;
	private String pack;
	private Date create_date;
	private String editior_recommend;
	private String content_abstract;
	private String author_abstract;
	private String director;
	private double sale;
	private double stock;
	private String media_commentary; 
	private Category category;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public Date getPress_date() {
		return press_date;
	}
	public void setPress_date(Date press_date) {
		this.press_date = press_date;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public Date getPrint_date() {
		return print_date;
	}
	public void setPrint_date(Date print_date) {
		this.print_date = print_date;
	}
	public String getImpression() {
		return impression;
	}
	public void setImpression(String impression) {
		this.impression = impression;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getWord_num() {
		return word_num;
	}
	public void setWord_num(String word_num) {
		this.word_num = word_num;
	}
	public String getPage_num() {
		return page_num;
	}
	public void setPage_num(String page_num) {
		this.page_num = page_num;
	}
	public String getSizes() {
		return sizes;
	}
	public void setSizes(String sizes) {
		this.sizes = sizes;
	}
	public String getPaper() {
		return paper;
	}
	public void setPaper(String paper) {
		this.paper = paper;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDprice() {
		return dprice;
	}
	public void setDprice(double dprice) {
		this.dprice = dprice;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getEditior_recommend() {
		return editior_recommend;
	}
	public void setEditior_recommend(String editior_recommend) {
		this.editior_recommend = editior_recommend;
	}
	public String getContent_abstract() {
		return content_abstract;
	}
	public void setContent_abstract(String content_abstract) {
		this.content_abstract = content_abstract;
	}
	public String getAuthor_abstract() {
		return author_abstract;
	}
	public void setAuthor_abstract(String author_abstract) {
		this.author_abstract = author_abstract;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public double getSale() {
		return sale;
	}
	public void setSale(double sale) {
		this.sale = sale;
	}
	public double getStock() {
		return stock;
	}
	public void setStock(double stock) {
		this.stock = stock;
	}
	public String getMedia_commentary() {
		return media_commentary;
	}
	public void setMedia_commentary(String media_commentary) {
		this.media_commentary = media_commentary;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author
				+ ", category_id=" + category_id + ", cover=" + cover
				+ ", edition=" + edition + ", press_date=" + press_date
				+ ", press=" + press + ", print_date=" + print_date
				+ ", impression=" + impression + ", isbn=" + isbn
				+ ", word_num=" + word_num + ", page_num=" + page_num
				+ ", sizes=" + sizes + ", paper=" + paper + ", price=" + price
				+ ", dprice=" + dprice + ", pack=" + pack + ", create_date="
				+ create_date + ", editior_recommend=" + editior_recommend
				+ ", content_abstract=" + content_abstract
				+ ", author_abstract=" + author_abstract + ", director="
				+ director + ", sale=" + sale + ", stock=" + stock
				+ ", media_commentary=" + media_commentary + ", category="
				+ category + "]";
	}
	public Book(String id, String name, String author, String category_id,
			String cover, String edition, Date press_date, String press,
			Date print_date, String impression, String isbn, String word_num,
			String page_num, String sizes, String paper, double price,
			double dprice, String pack, Date create_date,
			String editior_recommend, String content_abstract,
			String author_abstract, String director, double sale, double stock,
			String media_commentary, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.category_id = category_id;
		this.cover = cover;
		this.edition = edition;
		this.press_date = press_date;
		this.press = press;
		this.print_date = print_date;
		this.impression = impression;
		this.isbn = isbn;
		this.word_num = word_num;
		this.page_num = page_num;
		this.sizes = sizes;
		this.paper = paper;
		this.price = price;
		this.dprice = dprice;
		this.pack = pack;
		this.create_date = create_date;
		this.editior_recommend = editior_recommend;
		this.content_abstract = content_abstract;
		this.author_abstract = author_abstract;
		this.director = director;
		this.sale = sale;
		this.stock = stock;
		this.media_commentary = media_commentary;
		this.category = category;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
} 
