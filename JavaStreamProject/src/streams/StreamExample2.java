package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

class Student {
	String name;
	int score;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
}

public class StreamExample2 {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(new Student("���翵", 90),
										   new Student("������", 80),
										   new Student("������", 70),
										   new Student("����", 60));
		
		Stream<Student> students = list.stream();
		long iCnt = 0;
		students.filter(t -> t.score >= 60)
			.peek(t -> System.out.println("peek -> " + t.name + ", " + t.score))
			.filter(t -> t.name.startsWith("��"))
			.forEach(new Consumer<Student>() {
				@Override
				public void accept(Student t ) {
				System.out.println("forEach -> " + t.name + ", " + t.score);
				}
			});
		System.out.println("�� �ο� : " + iCnt);
		}
}
