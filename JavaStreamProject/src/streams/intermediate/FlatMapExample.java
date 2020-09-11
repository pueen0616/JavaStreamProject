package streams.intermediate;

import java.time.LocalDate;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class FlatMapExample {
	public static void main(String[] args) {
//		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
//		stream.flatMap(new Function<Integer, Stream<Integer>>() {
//			@Override
//			public Stream<Integer> apply(Integer t) {
//				return Stream.of(t * 3);
//			}
//		}).forEach(System.out::println);

		// double Income
		OptionalDouble result = Employee.employees().stream().flatMapToDouble(new Function<Employee, DoubleStream>() {
			@Override
			public DoubleStream apply(Employee t) {
				return DoubleStream.of(t.getIncome());
			}
		}).reduce(new DoubleBinaryOperator() {

			@Override
			public double applyAsDouble(double left, double right) {
				System.out.println(left + ", " + right);
				return left < right ? left : right;
			}
		});
		System.out.println(result);

//		if (result.isPresent()) isPresent 값이 존재하는지 없는지 
//			System.out.println("result: " + result);
//		else
//			System.out.println("결과 없음");

		// String Name
		Employee.employees().stream().flatMap(new Function<Employee, Stream<String>>() {
			@Override
			public Stream<String> apply(Employee t) {
				return Stream.of(t.getName());
			}
		}).findFirst().ifPresent(System.out::println); //첫번째 이름 findFirst 출력
		
		
		Optional<LocalDate> result2 = Employee.employees().stream().flatMap(new Function<Employee, Stream<LocalDate>>(){
			@Override
			public Stream<LocalDate> apply(Employee t) {
				return Stream.of(t.getDateOfBirth());
			}
		}).reduce(new BinaryOperator<LocalDate>() {
			@Override
			public LocalDate apply(LocalDate t, LocalDate u) {
				System.out.println(t + ", " + u);
				return t.isBefore(u) ? u : t;
			}
		});
		System.out.println("min 값 : " + result2.get());
	}
}
