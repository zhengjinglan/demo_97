package com.aaa.demo.entity;

public class MenuTwo {
	private Integer id;
	private String name;
	private String url;
	private Integer moid;

	public MenuTwo() {
		super();
	}

	public MenuTwo(String name, String url, Integer moid) {
		super();
		this.name = name;
		this.url = url;
		this.moid = moid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getMoid() {
		return moid;
	}

	public void setMoid(Integer moid) {
		this.moid = moid;
	}

	@Override
	public String toString() {
		return "MenuTwo [id=" + id + ", name=" + name + ", url=" + url
				+ ", moid=" + moid + "]";
	}

}
