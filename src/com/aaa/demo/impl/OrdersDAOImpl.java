package com.aaa.demo.impl;

import java.util.List;
import java.util.Map;

import com.aaa.demo.dao.IOrdersDAO;
import com.aaa.demo.entity.Orders;
import com.aaa.demo.factory.BaseDAO;

public class OrdersDAOImpl implements IOrdersDAO {

	@Override
	public boolean AddOrders(Orders order) {
		String sql = "insert into Orders(CustomerID,EmployeeID,OrderDate,ShippedDate,ShipVia,Freight,ShipName,ShipAddress) "
				+ " values(?,?,?,?,?,?,?,?)";
		Object[] objs = { order.getCustomerID(), order.getEmployeeID(),
				order.getOrderDate(), order.getShippedDate(),
				order.getShipVia(), order.getFreight(), order.getShipName(),
				order.getShipAddress() };
		int res = BaseDAO.exectUpdate(sql, objs);
		if (res == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Map<String, Object>> QueryAll() {
		String sql = "select OrderID,CustomerID,EmployeeID,OrderDate,RequiredDate,"
				+ "ShippedDate,ShipVia,Freight,ShipName,ShipAddress from Orders";
		return BaseDAO.Query(sql, null);
	}

}
