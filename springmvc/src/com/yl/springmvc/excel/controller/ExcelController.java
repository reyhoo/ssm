package com.yl.springmvc.excel.controller;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yl.springmvc.excel.service.ExcelExportService;
import com.yl.springmvc.excel.view.ExcelView;
import com.yl.springmvc.params.service.RoleService;
import com.yl.springmvc.pojo.PageParams;
import com.yl.springmvc.pojo.Role;
import com.yl.springmvc.pojo.RoleParams;

@Controller
@RequestMapping("excel")
public class ExcelController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping(value="exportRoles")
	public ModelAndView exportRoles() {
		ModelAndView mv = new ModelAndView();
		ExcelView excelView = new ExcelView(excelExportService());
		excelView.setFileName("所有角色.xls");
		RoleParams roleParams = new RoleParams();
//		PageParams pageParams = new PageParams();
//		roleParams.setPageParams(pageParams);
		List<Role> list = roleService.findRoles(roleParams);
		mv.addObject("roleList", list);
		mv.setView(excelView);
		return mv;
	}
	private ExcelExportService excelExportService() {
		return new ExcelExportService() {
			
			@Override
			public void makeWorkBook(Map<String, Object> model, Workbook workbook) {
				List<Role> list = (List<Role>) model.get("roleList");
				Sheet sheet = workbook.createSheet("所有角色");
				Row title = sheet.createRow(0);
				title.createCell(0).setCellValue("编号");
				title.createCell(1).setCellValue("名称");
				title.createCell(2).setCellValue("备注");
				for(int i = 0;i < list.size(); i ++ ) {
					Role role = list.get(i);
					int rowIndex = i + 1;
					Row row = sheet.createRow(rowIndex);
					row.createCell(0).setCellValue(role.getId());
					row.createCell(1).setCellValue(role.getRoleName());
					row.createCell(2).setCellValue(role.getNote());
				}
			}
		};
	}
}
