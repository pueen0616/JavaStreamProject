package streams.collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionMapGroupbyExample {
	public static void main(String[] args) {
		// �μ��� - �������
		Student s1 = new Student("�㼺��", 28, Gender.MALE);
		Student s3 = new Student("������", 28, Gender.FEMALE);
		Student s4 = new Student("�����", 28, Gender.FEMALE);
		Student s2 = new Student("������", 25, Gender.MALE);
		List<Student> students = Arrays.asList(s1, s3, s4, s2);
		
//		Gender.MALE = Student1, Student2;
//		Gender.FEMALE = Student3, Student4;
		
		//Collectors.toSet���� ��ƿ��ٴ�
		Map<Gender, List<Student>> gMap = students.stream()
				.collect(Collectors.groupingBy(new Function<Student, Gender>() {
			@Override
			public Gender apply(Student t) {
				return t.gender;
			}
		}, Collectors.toList()));
		
		Set<Gender> set = gMap.keySet();
		for(Gender g : set) {
			gMap.get(g);
			List<Student> list = gMap.get(g);
			for(Student s : list) {
				System.out.println(s.name + ", " + s.age);
			}
		}
	}
}
