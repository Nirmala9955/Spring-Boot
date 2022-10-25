package com.sahu.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.sahu.model.Employee;

@Component("excel_report")
public class EmployeeExcelView extends AbstractXlsView {

	private static int i=0;
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//Get model attribute 
		Iterable<Employee> empList = (Iterable<Employee>) model.get("empList");
		//Create a Sheet
		Sheet sheet1 = workbook.createSheet("Sheet1");
		//Add cells to sheet
		empList.forEach(emp->{
			//add row to sheet representing Employee record
			Row row = sheet1.createRow(i);
			row.createCell(0).setCellValue(emp.getEmpno());
			row.createCell(1).setCellValue(emp.getEname());
			row.createCell(2).setCellValue(emp.getJob());
			row.createCell(3).setCellValue(emp.getSal());
			row.createCell(4).setCellValue(emp.getDeptno());
			i++;
		});
	}

}
