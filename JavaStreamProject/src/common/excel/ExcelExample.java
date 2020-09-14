package common.excel;

import java.sql.SQLException;
import java.util.List;

import basic.common.EmpDAO;
import basic.common.Employee;

public class ExcelExample {
	public static void main(String[] args) {
		EmployeeExcelWriter writer = new EmployeeExcelWriter();
			try {
				List<Employee> list = EmpDAO.getEmpList();
				writer.xlsWriter(list);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("¿¢¼¿ ¿Ï·á.");
	}
}
