package streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntExample {
	public static void main(String[] args) {
		//1~10 정수 배열
		int[] intAry = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		//배열로부터 스트림 생성
		IntStream iStream = Arrays.stream(intAry);
		//짝수값만 필터
		int sum = iStream.filter(value -> value%2 == 0)
		.sum();
		System.out.println(sum);
		System.out.println();
		
		IntStream.range(1, 10).forEach(s -> System.out.println(s));
		System.out.println("---rangeClosed-------");
		IntStream.rangeClosed(1, 10).forEach(System.out::println);
		System.out.println("---rangeClosed-------");
		IntStream.rangeClosed(1, 10).filter(n -> n>5) //1~10 중 5보다 큰 범위 출력
		.forEach(System.out::println);
	}
}
