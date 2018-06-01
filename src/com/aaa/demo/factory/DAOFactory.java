package com.aaa.demo.factory;

import com.aaa.demo.dao.ICategoriesDAO;
import com.aaa.demo.dao.IEmpsDAO;
import com.aaa.demo.dao.IOrderDetailsDAO;
import com.aaa.demo.dao.IOrdersDAO;
import com.aaa.demo.dao.IProductsDAO;
import com.aaa.demo.dao.IShippersDAO;
import com.aaa.demo.dao.ISuppliersDAO;
import com.aaa.demo.dao.IcustomerDAO;
import com.aaa.demo.impl.CategoriesDAOImpl;
import com.aaa.demo.impl.CustomerDAOImpl;
import com.aaa.demo.impl.EmpsDAOImpl;
import com.aaa.demo.impl.OrderDetailsDAOImpl;
import com.aaa.demo.impl.OrdersDAOImpl;
import com.aaa.demo.impl.ProductsDAOImpl;
import com.aaa.demo.impl.ShippersDAOImpl;
import com.aaa.demo.impl.SuppliersDAOImpl;

public class DAOFactory {
	public static IEmpsDAO emps = new EmpsDAOImpl();
	public static IcustomerDAO cus = new CustomerDAOImpl();
	public static ISuppliersDAO sup = new SuppliersDAOImpl();
	public static IProductsDAO ps = new ProductsDAOImpl();
	public static ICategoriesDAO cat = new CategoriesDAOImpl();
	public static IShippersDAO shi = new ShippersDAOImpl();
	public static IOrdersDAO orders = new OrdersDAOImpl();
	public static IOrderDetailsDAO details = new OrderDetailsDAOImpl();
}
