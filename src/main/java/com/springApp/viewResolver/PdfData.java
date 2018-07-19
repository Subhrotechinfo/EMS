package com.springApp.viewResolver;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.springApp.entity.Employee;

public class PdfData extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Inside pdf data");
		
		//get the datas
		@SuppressWarnings("unchecked")
		List<Employee> emp = (List<Employee>) model.get("pdfinfo");
		System.out.println("PDF Data");
		PdfPTable table = new PdfPTable(4);
		//table.setWidths(arg0);
		//(new int[] {10,60,40,50});
		
		table.addCell("ID");
		table.addCell("First Name");
		table.addCell("Last Name");
		table.addCell("Email");
		
		for (Employee employee : emp) {
			
			table.addCell(String.valueOf(employee.getId()));
			table.addCell(employee.getFirstname());
			table.addCell(employee.getLastname());
			table.addCell(employee.getEmail());
			
		}	
		document.add(table);
	}
	
	
	
}
