package com.mybatis.pojo;

public class PageParam {

	private int start;
	private int limit;
	
	
	public void setStart(int start) {
		this.start = start;
	}
	
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public int getStart() {
		return start;
	}
	
	public int getLimit() {
		return limit;
	}
}
