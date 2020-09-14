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
		// 입사일자 기준
		// List 컬렉션에 저장

		// employee 테이블
		List<Employee> empList = null;
		try {
			empList = EmpDAO.getEmpList();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 입사일자 기준
		System.out.println("입사일자가 1990이후 입사한 사람들");
		Collector<Employee, ?, List<Employee>> collector = Collectors.toList();
		List<Employee> newList = empList.stream().filter(e -> e.getHireDate().isAfter(LocalDate.of(1990, 1, 1)))
				.collect(collector);
		
		newList.stream().forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));

		// Job -> ST_CLERK 인 사람들의 이름과 급여 컬렉션에 저장
		System.out.println();
		System.out.println("잡ID가 ST_CLERK인 사람들");
		List<Employee> newList1 = empList.stream().filter(e -> e.getJobId().equals("ST_CLERK"))
				.collect(collector);

		newList1.stream().forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));
		
//		System.out.println();
//		System.out.println("잡ID가 ST_CLERK인 사람들");
//		Map<String, String> newList2 = empList.stream().filter(e -> e.getJobId().equals("ST_CLERK"))
//				.collect(new Function<String, String>());
//
//		newList1.stream().forEach(s -> System.out.println(s.getFirstName() + " " + s.getLastName()));
	}
}
