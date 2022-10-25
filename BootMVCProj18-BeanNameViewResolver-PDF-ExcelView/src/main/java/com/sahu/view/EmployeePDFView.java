package com.sahu.view;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.sahu.model.Employee;

@Component("pdf_report")
public class EmployeePDFView extends AbstractPdfView {
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//Get model attribute  data
		Iterable<Employee> empList = (Iterable<Employee>) model.get("empList");
		//Add Paragraph
		Paragraph paragraph = new Paragraph("Employee Report", new Font(Font.BOLDITALIC));
		document.add(paragraph);
		//Add table content
		Table table = new Table(5, ((ArrayList<Employee>) empList).size());
		for (Employee emp: empList) {
			table.addCell(String.valueOf(emp.getEmpno()));
			table.addCell(emp.getEname());
			table.addCell(emp.getJob());
			table.addCell(String.valueOf(emp.getSal()));
			table.addCell(String.valueOf(emp.getDeptno()));
		}
		document.add(table);
	}
	
}
