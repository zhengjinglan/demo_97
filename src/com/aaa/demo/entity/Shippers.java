package com.aaa.demo.entity;

public class Shippers {
	private Integer shipperID;
	private String companyName;
	private String phone;

	public Shippers() {
		super();
	}

	public Shippers(String companyName, String phone) {
		super();
		this.companyName = companyName;
		this.phone = phone;
	}

	public Integer getShipperID() {
		return shipperID;
	}

	public void setShipperID(Integer shipperID) {
		this.shipperID = shipperID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Shippers [shipperID=" + shipperID + ", companyName="
				+ companyName + ", phone=" + phone + "]";
	}

}
