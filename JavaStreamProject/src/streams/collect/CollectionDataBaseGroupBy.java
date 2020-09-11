package streams.collect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.security.sasl.SaslException;

import basic.common.EmpDAO;
import basic.common.Employee;
import streams.intermediate.Student;

public class CollectionDataBaseGroupBy {
	public static void main(String[] args) {
		// 부서별 - 사원이름
		List<Employee> empList = null;
		try {
			empList = EmpDAO.getEmpList();
		} catch (SaslException e) {
			e.printStackTrace();
		}

		Collector<Employee, ?, List<Employee>> collector = Collectors.toList();
		Map<String, List<Employee>> newList = empList.stream()
				.collect(Collectors.groupingBy(new Function<Employee, String>() {

					@Override
					public String apply(Employee t) {
						return t.getJobId();
					}
				}, Collectors.toList()));
		
		Set<String> set = newList.keySet();
		for(String s : set) {
			System.out.println();
			System.out.println("----" + s + "----");
			
			newList.get(s);
			List<Employee> list = newList.get(s);
			for(Employee e : list) {
				System.out.println(e.getFirstName());
				
			}
		}
	}
}
