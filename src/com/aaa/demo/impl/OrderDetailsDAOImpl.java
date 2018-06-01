package com.aaa.demo.impl;

import java.util.List;
import java.util.Map;

import com.aaa.demo.dao.IOrderDetailsDAO;
import com.aaa.demo.entity.OrderDetails;
import com.aaa.demo.factory.BaseDAO;

public class OrderDetailsDAOImpl implements IOrderDetailsDAO {

	@Override
	public boolean AddOrders(OrderDetails od) {
		String sql = "insert into OrderDetails(OrderID,ProductID,UnitPrice,Quantity,Discount) "
				+ " values(?,?,?,?,?)";
		Object[] objs = { od.getOrderID(), od.getProductID(),
				od.getUnitPrice(), od.getQuantity(), od.getDiscount() };
		int res = BaseDAO.exectUpdate(sql, objs);
		if (res == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Map<String, Object>> QueryAll() {
		String sql = "select OrderID,ProductID,UnitPrice,Quantity,Discount from OrderDetails";
		return BaseDAO.Query(sql, null);
	}

}
