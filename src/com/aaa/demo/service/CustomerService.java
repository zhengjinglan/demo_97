package com.aaa.demo.service;

import java.util.List;
import java.util.Map;

import com.aaa.demo.entity.Customers;
import com.aaa.demo.entity.PageList;
import com.aaa.demo.factory.DAOFactory;

public class CustomerService {

	public List<Map<String, Object>> QueryAll(Customers cs) {

		return DAOFactory.cus.QueryAll(cs);
	}

	public PageList QueryByPage(Customers cs, Integer pageSize, Integer pageNum) {
		return DAOFactory.cus.QueryByPage(cs, pageSize, pageNum);
	}

	public boolean AddCs(Customers cs) {

		return DAOFactory.cus.AddCs(cs);
	}

	public List<Map<String, Object>> QueryById(String id) {

		return DAOFactory.cus.QueryById(id);
	}

	public boolean UpdaCs(Customers customers, String id) {

		return DAOFactory.cus.UpdaCs(customers, id);
	}

	public int DelCs(String id) {
		// TODO Auto-generated method stub
		return DAOFactory.cus.DelCs(id);
	}
}
