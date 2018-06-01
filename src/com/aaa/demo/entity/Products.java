package com.aaa.demo.entity;

public class Products {
	private Integer productID;
	private String productName;
	private Integer supplierID;
	private Integer categoryID;
	private String quantityPerUnit;
	private String unitPrice;
	private Integer unitsInStock;
	private Integer unitsOnOrder;
	private Integer reorderLevel;
	private Integer discontinued;
	private String companyName;
	private String categoryName;

	public Products(String productName, Integer supplierID, Integer categoryID,
			String quantityPerUnit, String unitPrice, Integer unitsInStock,
			Integer unitsOnOrder, Integer reorderLevel, Integer discontinued) {
		super();
		this.productName = productName;
		this.supplierID = supplierID;
		this.categoryID = categoryID;
		this.quantityPerUnit = quantityPerUnit;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.unitsOnOrder = unitsOnOrder;
		this.reorderLevel = reorderLevel;
		this.discontinued = discontinued;
	}

	public Products(Integer productID, String productName) {
		super();
		this.productID = productID;
		this.productName = productName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(Integer supplierID) {
		this.supplierID = supplierID;
	}

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(Integer unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public Integer getUnitsOnOrder() {
		return unitsOnOrder;
	}

	public void setUnitsOnOrder(Integer unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}

	public Integer getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(Integer reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public Integer getDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(Integer discontinued) {
		this.discontinued = discontinued;
	}

	@Override
	public String toString() {
		return "Products [productID=" + productID + ", productName="
				+ productName + ", supplierID=" + supplierID + ", categoryID="
				+ categoryID + ", quantityPerUnit=" + quantityPerUnit
				+ ", unitPrice=" + unitPrice + ", unitsInStock=" + unitsInStock
				+ ", unitsOnOrder=" + unitsOnOrder + ", reorderLevel="
				+ reorderLevel + ", discontinued=" + discontinued
				+ ", companyName=" + companyName + ", categoryName="
				+ categoryName + "]";
	}

}
