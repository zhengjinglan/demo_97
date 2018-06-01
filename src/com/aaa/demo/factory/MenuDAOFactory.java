package com.aaa.demo.factory;

import com.aaa.demo.dao.IMenuOneDAO;
import com.aaa.demo.impl.MenuOneDAOImpl;

public class MenuDAOFactory {
	public static IMenuOneDAO one = new MenuOneDAOImpl();
	// public static IMenuTwoDAO two = new MenuTwoDAOImpl();
}
