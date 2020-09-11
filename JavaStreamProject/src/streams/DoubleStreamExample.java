package streams;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class DoubleStreamExample {
	public static void main(String[] args) {		
		double[] dAry = { 2.3, 4.5, 8.3, 5.5, 4.6 };
		// 스트림생성
		DoubleStream dstream = Arrays.stream(dAry);

		float sum = (float) dstream.filter(value -> value < 5)
		.sum();
		System.out.println("5미만 값의 합은 총 : " + sum);
		
		LongStream lStream = Arrays.stream(new long[] {10, 29, 38});
		IntStream iStream = Arrays.stream(new int[] {1, 2, 3});
		
		Stream<Double> dStream = Arrays.stream(new Double[] {1.1, 2.2});
		Stream<String> sStream = Arrays.stream(new String[] {"Hong", "Park"});
		Stream<Student> tStream = Arrays.stream(new Student[] {new Student("동", 50)});
	}
}
