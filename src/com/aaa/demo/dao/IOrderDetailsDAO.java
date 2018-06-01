package com.aaa.demo.dao;

import java.util.List;
import java.util.Map;

import com.aaa.demo.entity.OrderDetails;

public interface IOrderDetailsDAO {
	public boolean AddOrders(OrderDetails od);

	public List<Map<String, Object>> QueryAll();
}
