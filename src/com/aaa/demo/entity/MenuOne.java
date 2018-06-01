package com.aaa.demo.entity;

public class MenuOne {
	private Integer moid;
	private String name;

	public MenuOne(String name) {
		super();
		this.name = name;
	}

	public MenuOne() {
		super();
	}

	public Integer getMoid() {
		return moid;
	}

	public void setMoid(Integer moid) {
		this.moid = moid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MenuOne [moid=" + moid + ", name=" + name + "]";
	}

}
