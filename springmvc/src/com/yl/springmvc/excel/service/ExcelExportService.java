package com.yl.springmvc.excel.service;

import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;

public interface ExcelExportService {

	public void makeWorkBook(Map<String, Object>model,Workbook workbook);
	
}
