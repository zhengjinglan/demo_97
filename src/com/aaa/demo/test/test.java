package com.aaa.demo.test;

import com.aaa.demo.factory.ServiceFactory;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(EmpsServiceFactory.emp.QueryByPage());
		/*
		 * int res = EmpsDAOFactory.emps.AddEmp(new Emps("李四", "1994-2-1",
		 * "2016-1-5", "郑州", "123123", "15236456325")); if (res == 1) {
		 * System.out.println("成功"); } else { System.out.println("失败"); }
		 */
		/*
		 * int res = DAOFactory.emps.DelEmp(17); if (res == 1) {
		 * System.out.println("成功"); } else { System.out.println("失败"); }
		 */
		// System.out.println(DAOFactory.cus.QueryAll(new Customers()));
		System.out.println(ServiceFactory.ss.QueryById(1));
	}

}
