package com.lbt.entity;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
	/**
	 * 对类别进行实例化
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String parent_id;
	private String levels;
	private Category category;
	private List<Category> sons;
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
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getLevels() {
		return levels;
	}
	public void setLevels(String levels) {
		this.levels = levels;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public List<Category> getSons() {
		return sons;
	}
	public void setSons(List<Category> sons) {
		this.sons = sons;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", parent_id="
				+ parent_id + ", levels=" + levels + ", category=" + category
				+ ", sons=" + sons + "]";
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String id, String name, String parent_id, String levels,
			Category category, List<Category> sons) {
		super();
		this.id = id;
		this.name = name;
		this.parent_id = parent_id;
		this.levels = levels;
		this.category = category;
		this.sons = sons;
	}
}
