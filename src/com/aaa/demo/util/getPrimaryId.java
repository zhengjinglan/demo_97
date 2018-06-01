package com.aaa.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class getPrimaryId {

	public static Integer getOrderId() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String id = sdf.format(date);
		Integer num = (int) (Math.random() * 100);
		return Integer.parseInt(id + num.toString());
	}
}
