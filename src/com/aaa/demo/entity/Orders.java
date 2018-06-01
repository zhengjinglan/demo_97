package com.aaa.demo.entity;

public class Orders {
	private Integer orderID;
	private String customerID;
	private Integer employeeID;
	private String orderDate;
	private String requiredDate;
	private String shippedDate;
	private Integer shipVia;
	private String freight;
	private String shipName;
	private String shipAddress;

	public Orders() {
		super();
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(String requiredDate) {
		this.requiredDate = requiredDate;
	}

	public String getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(String shippedDate) {
		this.shippedDate = shippedDate;
	}

	public Integer getShipVia() {
		return shipVia;
	}

	public void setShipVia(Integer shipVia) {
		this.shipVia = shipVia;
	}

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	@Override
	public String toString() {
		return "Orders [orderID=" + orderID + ", customerID=" + customerID
				+ ", employeeID=" + employeeID + ", orderDate=" + orderDate
				+ ", requiredDate=" + requiredDate + ", shippedDate="
				+ shippedDate + ", shipVia=" + shipVia + ", freight=" + freight
				+ ", shipName=" + shipName + ", shipAddress=" + shipAddress
				+ "]";
	}

}
