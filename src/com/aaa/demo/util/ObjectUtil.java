package com.aaa.demo.util;

public class ObjectUtil {
	public static Integer toInteger(Object obj) {
		if (obj != null && !"".equals(obj.toString().trim())) {
			return Integer.parseInt(obj.toString());
		} else {
			return null;
		}

	}

	public static String toString(Object obj) {
		if (obj != null && !"".equals(obj.toString().trim())) {
			return obj.toString();
		} else {
			return null;
		}

	}
}
