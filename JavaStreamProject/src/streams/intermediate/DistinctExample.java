package streams.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class DistinctExample {
	public static void main(String[] args) {
		String[] strAry = {"Hong", "Park", "Choi", "Hong"};
		Stream<String> sStream = Arrays.stream(strAry);
//		sStream.distinct().forEach(System.out::println);
		
		sStream = Arrays.stream(strAry);
		sStream.sorted().forEach(System.out::println); //sorted�޼ҵ� (�������� ������ ����)
		
		//hashCode�� equals�� ��
		Student[] students = {new Student("��ȭ��", 50),
				new Student("������", 60),
				new Student("��û��", 70),
				new Student("��û��", 80),
				new Student("�赵��", 70),
				new Student("�赵��", 90)};
		Stream<Student> tStream = Arrays.stream(students);
//		tStream.distinct().forEach(System.out::println);
//		tStream.sorted().forEach(System.out::println);
		tStream.sorted(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				return o2.score - o1.score;
			}}).forEach(System.out::println);
		}
	}

