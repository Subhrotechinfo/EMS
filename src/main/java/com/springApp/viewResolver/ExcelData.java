package com.springApp.viewResolver;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.springApp.entity.Employee;


public class ExcelData extends AbstractXlsView{
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		response.setHeader("Content-disposition", "attachment ; filename=\"employeeData.xls\"");
		
		@SuppressWarnings("unchecked")
		List<Employee> list = (List<Employee>) model.get("excelinfo");
		
		Sheet sheet = workbook.createSheet("Employee List"); 
		
		Row header  = sheet.createRow(0);
		
		header.createCell(0).setCellValue("ID");
		header.createCell(1).setCellValue("First");
		header.createCell(2).setCellValue("Last");
		header.createCell(3).setCellValue("email");
		
		int rowNum = 1;
		
		for (Employee emp : list) {
			
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(emp.getId());
			row.createCell(1).setCellValue(emp.getFirstname());
			row.createCell(2).setCellValue(emp.getLastname());
			row.createCell(3).setCellValue(emp.getEmail());
			
		}
	}

}
