package streams.intermediate;

import java.util.List;
import java.util.function.Predicate;

public class FilterExample {
	public static void main(String[] args) {
		List<Employee> list = Employee.employees();
//		list.stream().filter(new Predicate<Employee>() {
//
//			@Override
//			public boolean test(Employee t) {
//				return t.isMale();
//			}
//		}).peek(s -> { // peek로 중간처리하고
//			s.setIncome(s.getIncome() * 0.9); //연봉 깎기
//		}).forEach(System.out::println); //forEach로 마무리
		System.out.println("------------------------------------------------------");
		list.stream().filter(s -> s.getIncome() > 3000).forEach(System.out::println);
	}
}
