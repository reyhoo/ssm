package com.yl;

public class StringUtils {

	
	public  static boolean  isNotEmpty(String s) {
		if(s == null)return false;
		if("".equals(s)) {
			return false;
		}
		return true;
	}
}
