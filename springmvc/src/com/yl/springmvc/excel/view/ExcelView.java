package com.yl.springmvc.excel.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.StringUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.yl.springmvc.excel.service.ExcelExportService;

public class ExcelView extends AbstractXlsView {
	
	
	private String fileName = null;
	private ExcelExportService  excelExportService;
	
	
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ExcelView(ExcelExportService  excelExportService) {
		setExcelExportService(excelExportService);
	}
	
	public ExcelView(String viewName,ExcelExportService  excelExportService) {
		this.setBeanName(viewName);
		setExcelExportService(excelExportService);
	}
	
	
	
	public void setExcelExportService(ExcelExportService excelExportService) {
		this.excelExportService = excelExportService;
	}
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if(excelExportService == null) {
			throw new RuntimeException("导出服务接口不能为null!!");
		}
		if(!StringUtils.isEmpty(fileName)) {
			String reqCharset = request.getCharacterEncoding();
			reqCharset = reqCharset == null ? "UTF-8":reqCharset;
			fileName = new String(fileName.getBytes(reqCharset),"ISO8859-1");
			response.setHeader("Content-disposition", "attachment;filename="+fileName);
		}
		excelExportService.makeWorkBook(model, workbook);
	}

}
