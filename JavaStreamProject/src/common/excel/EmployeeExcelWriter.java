package common.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import basic.common.Employee;

public class EmployeeExcelWriter {
	public void xlsWriter(List<Employee> list) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell;

		cell = row.createCell(0);
		cell.setCellValue("EmployeeID");

		cell = row.createCell(1);
		cell.setCellValue("FirstName");

		cell = row.createCell(2);
		cell.setCellValue("LastName");

		cell = row.createCell(3);
		cell.setCellValue("Email");

		cell = row.createCell(4);
		cell.setCellValue("Salary");

		Employee emp;
		for (int i = 0; i < list.size(); i++) {
			emp = list.get(i);

			row = sheet.createRow(i + 1);
			
			cell = row.createCell(0);
			cell.setCellValue(emp.getEmployeeId());

			cell = row.createCell(1);
			cell.setCellValue(emp.getFirstName());

			cell = row.createCell(2);
			cell.setCellValue(emp.getLastName());

			cell = row.createCell(3);
			cell.setCellValue(emp.getEmail());

			cell = row.createCell(4);
			cell.setCellValue(emp.getSalary());
		}

		File file = new File("employeeExcel.xls");
		FileOutputStream fos = null; // 쓰기 용도로 파일을 하나 열겠다.

		try {
			fos = new FileOutputStream(file); // 파일을 읽고 쓰는 거는 예외 처리 필요 try/catch
			try {
				workbook.write(fos);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {

			try {
				if (workbook != null)
					workbook.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
