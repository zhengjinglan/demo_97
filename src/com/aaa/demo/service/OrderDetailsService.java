package com.aaa.demo.service;

import java.util.List;
import java.util.Map;

import com.aaa.demo.entity.OrderDetails;
import com.aaa.demo.factory.ServiceFactory;

public class OrderDetailsService {
	public boolean AddOd(OrderDetails od) {
		return ServiceFactory.details.AddOd(od);
	}

	public List<Map<String, Object>> QueryAll() {
		return ServiceFactory.details.QueryAll();
	}
}
