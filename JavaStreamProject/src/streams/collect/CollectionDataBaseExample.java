package streams.collect;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.security.sasl.SaslException;

import basic.common.EmpDAO;
import basic.common.Employee;

public class CollectionDataBaseExample {
	public static void main(String[] args) {
		// �Ի����� ����
		// List �÷��ǿ� ����

		// employee ���̺�
		List<Employee> empList = null;
		try {
			empList = EmpDAO.getEmpList();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// �Ի����� ����
		System.out.println("�Ի����ڰ� 1990���� �Ի��� �����");
		Collector<Employee, ?, List<Employee>> collector = Collectors.toList();
		List<Employee> newList = empList.stream().filter(e -> e.getHireDate().isAfter(LocalDate.of(1990, 1, 1)))
				.collect(collector);
		
		newList.stream().forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));

		// Job -> ST_CLERK �� ������� �̸��� �޿� �÷��ǿ� ����
		System.out.println();
		System.out.println("��ID�� ST_CLERK�� �����");
		List<Employee> newList1 = empList.stream().filter(e -> e.getJobId().equals("ST_CLERK"))
				.collect(collector);

		newList1.stream().forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));
		
//		System.out.println();
//		System.out.println("��ID�� ST_CLERK�� �����");
//		Map<String, String> newList2 = empList.stream().filter(e -> e.getJobId().equals("ST_CLERK"))
//				.collect(new Function<String, String>());
//
//		newList1.stream().forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));
	}
}
