package com.aaa.demo.factory;

import com.aaa.demo.service.CategoriesService;
import com.aaa.demo.service.CustomerService;
import com.aaa.demo.service.EmpsService;
import com.aaa.demo.service.OrderDetailsService;
import com.aaa.demo.service.OrdersService;
import com.aaa.demo.service.ProductsService;
import com.aaa.demo.service.ShippersService;
import com.aaa.demo.service.SuppliersService;

public class ServiceFactory {
	public static ProductsService ps = new ProductsService();
	public static EmpsService emp = new EmpsService();
	public static CustomerService cs = new CustomerService();
	public static SuppliersService ss = new SuppliersService();
	public static CategoriesService cats = new CategoriesService();
	public static ShippersService shis = new ShippersService();
	public static OrderDetailsService details = new OrderDetailsService();
	public static OrdersService orders = new OrdersService();
}
