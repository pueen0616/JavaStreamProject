package basic.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.sasl.SaslException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EmpDAO {
	public static ObservableList<Employee> getEmpList() throws SaslException {
		Connection conn = ConnectionDB.getDB();
		
		String sql = "select * from employees";
		
		ObservableList<Employee> list = FXCollections.observableArrayList();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				// 컬럼 이름
				Employee employee = new Employee(rs.getInt("employee_id"), rs.getString("first_Name"), rs.getString("last_name"),
												 rs.getString("email"),    rs.getDate("hire_date").toLocalDate(), 
												 rs.getString("job_id"),   rs.getInt("salary"));
				list.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}
