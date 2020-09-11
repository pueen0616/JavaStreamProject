package streams.collect;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//열거형 데이터 타입
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
		Student s1 = new Student("허성준", 28, Gender.MALE);
		Student s2 = new Student("최형준", 25, Gender.MALE);
		Student s3 = new Student("문선애", 28, Gender.FEMALE);
		//students에 리스트로 담는다
		List<Student> students = Arrays.asList(s1, s2, s3);
		
		
		//Collectors.tiList() = Collectors가 가지고 있는 toList()
		System.out.println("젠더가 MALE인 사람");
		Collector<Student, ?, List<Student>> collector = Collectors.toList();
		List<Student> newList = students.stream().filter(s -> s.gender == Gender.MALE).collect(collector);
		
		newList.stream().forEach(s -> System.out.println(s.name + ", " + s.age));
		
		//나이가 25살 넘는 사람들.
		System.out.println("나이가 25 넘는 사람");
		Set<Student> newList2 = students.stream().filter(s -> s.age > 25).collect(Collectors.toSet());
		
		Iterator<Student> iter = newList2.iterator();
		while (iter.hasNext()) {
			Student s = iter.next();
			System.out.println(s.name + ", " + s.age);
		}
		
	}
}
