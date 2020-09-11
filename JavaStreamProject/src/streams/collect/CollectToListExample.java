package streams.collect;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//������ ������ Ÿ��
enum Gender {
	MALE, FEMALE;
}

class Student {
	String name;
	int age;
	Gender gender;
	
	public Student(String name, int age, Gender gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
}

public class CollectToListExample {
	public static void main(String[] args) {
		Student s1 = new Student("�㼺��", 28, Gender.MALE);
		Student s2 = new Student("������", 25, Gender.MALE);
		Student s3 = new Student("������", 28, Gender.FEMALE);
		//students�� ����Ʈ�� ��´�
		List<Student> students = Arrays.asList(s1, s2, s3);
		
		
		//Collectors.tiList() = Collectors�� ������ �ִ� toList()
		System.out.println("������ MALE�� ���");
		Collector<Student, ?, List<Student>> collector = Collectors.toList();
		List<Student> newList = students.stream().filter(s -> s.gender == Gender.MALE).collect(collector);
		
		newList.stream().forEach(s -> System.out.println(s.name + ", " + s.age));
		
		//���̰� 25�� �Ѵ� �����.
		System.out.println("���̰� 25 �Ѵ� ���");
		Set<Student> newList2 = students.stream().filter(s -> s.age > 25).collect(Collectors.toSet());
		
		Iterator<Student> iter = newList2.iterator();
		while (iter.hasNext()) {
			Student s = iter.next();
			System.out.println(s.name + ", " + s.age);
		}
		
	}
}
