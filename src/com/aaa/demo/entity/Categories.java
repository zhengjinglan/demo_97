package com.aaa.demo.entity;

public class Categories {
	private Integer categoryID;
	private String categoryName;
	private String description;
	private String picture;

	public Categories(String categoryName, String description, String picture) {
		super();
		this.categoryName = categoryName;
		this.description = description;
		this.picture = picture;
	}

	public Categories() {

	}

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "Categories [categoryID=" + categoryID + ", categoryName="
				+ categoryName + ", description=" + description + ", picture="
				+ picture + "]";
	}

}
