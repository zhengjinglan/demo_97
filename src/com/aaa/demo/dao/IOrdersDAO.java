package com.aaa.demo.dao;

import java.util.List;
import java.util.Map;

import com.aaa.demo.entity.Orders;

public interface IOrdersDAO {
	public boolean AddOrders(Orders order);

	public List<Map<String, Object>> QueryAll();
}
