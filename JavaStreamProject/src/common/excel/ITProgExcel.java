package common.excel;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import basic.common.EmpDAO;
import basic.common.Employee;

public class ITProgExcel {
	public static void main(String[] args) {
		ExcelExmaple2 prog = new ExcelExmaple2();
		try {
			List<Employee> list = EmpDAO.getEmpList();
			
			//list1에 가공한걸 담음
			List<Employee> list1 = list.stream().filter(t -> t.getJobId().equals("IT_PROG")).collect(Collectors.toList());
			
			prog.xlsWriter(list1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("IT_PROG 완료.");
		
	}
}
