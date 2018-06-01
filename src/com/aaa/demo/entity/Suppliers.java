package com.aaa.demo.entity;

public class Suppliers {
	private Integer supplierID;
	private String companyName;
	private String contactName;
	private String contactTitle;
	private String address;
	private String postalCode;
	private String phone;

	public Suppliers(String companyName, String contactName, String phone) {
		super();
		this.companyName = companyName;
		this.contactName = contactName;
		this.phone = phone;
	}

	public Suppliers(String companyName, String contactName,
			String contactTitle, String address, String postalCode, String phone) {
		super();
		this.companyName = companyName;
		this.contactName = contactName;
		this.contactTitle = contactTitle;
		this.address = address;
		this.postalCode = postalCode;
		this.phone = phone;
	}

	public Integer getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(Integer supplierID) {
		this.supplierID = supplierID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactTitle() {
		return contactTitle;
	}

	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Suppliers [supplierID=" + supplierID + ", companyName="
				+ companyName + ", contactName=" + contactName
				+ ", contactTitle=" + contactTitle + ", address=" + address
				+ ", postalCode=" + postalCode + ", phone=" + phone + "]";
	}

}
