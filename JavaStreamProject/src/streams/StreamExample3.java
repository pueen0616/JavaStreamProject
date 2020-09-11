package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamExample3 {
	static int sum = 0, cnt = 0, avg = 0;

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("���翵", 90), new Student("������", 80), new Student("������", 70));

		// forEach
		Stream<Student> students = list.stream();
		students.filter(t -> t.score >= 60).forEach(new Consumer<Student>() {
			@Override
			public void accept(Student t) {
				sum += t.score;
				cnt++;
				avg = sum / cnt;
			}
		});
		System.out.println("������ -> " + sum + ", " + "��� -> " + avg);
	}
}
