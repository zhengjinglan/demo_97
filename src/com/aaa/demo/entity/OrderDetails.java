package com.aaa.demo.entity;

public class OrderDetails {
	private Integer orderID;
	private Integer productID;
	private String unitPrice;
	private Integer quantity;
	private String discount;

	public OrderDetails() {
		super();
	}

	public OrderDetails(Integer orderID, Integer productID, String unitPrice,
			Integer quantity) {
		super();
		this.orderID = orderID;
		this.productID = productID;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderID=" + orderID + ", productID=" + productID
				+ ", unitPrice=" + unitPrice + ", quantity=" + quantity
				+ ", discount=" + discount + "]";
	}

}
