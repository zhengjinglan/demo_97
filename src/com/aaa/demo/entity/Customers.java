package com.aaa.demo.entity;

public class Customers {
	private String customerID;
	private String companyName;
	private String contactName;
	private String contactTitle;
	private String address;
	private String phone;

	public Customers(String customerID, String companyName, String contactName,
			String contactTitle, String address, String phone) {
		super();
		this.customerID = customerID;
		this.companyName = companyName;
		this.contactName = contactName;
		this.contactTitle = contactTitle;
		this.address = address;
		this.phone = phone;
	}

	public Customers(String cname, String contactName, String phone) {
		super();
		this.companyName = cname;
		this.contactName = contactName;
		this.phone = phone;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customers [customerID=" + customerID + ", companyName="
				+ companyName + ", contactName=" + contactName
				+ ", contactTitle=" + contactTitle + ", address=" + address
				+ ", phone=" + phone + "]";
	}

}
