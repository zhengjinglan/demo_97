package com.aaa.demo.service;

import com.aaa.demo.entity.Orders;
import com.aaa.demo.factory.ServiceFactory;

public class OrdersService {
	public boolean AddOrder(Orders o) {
		return ServiceFactory.orders.AddOrder(o);
	}
}
