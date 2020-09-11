package streams.intermediate;

import java.util.Objects;

public class Student implements Comparable<Student> {
	String name;
	int score;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	// score �� equals
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student that = (Student) obj;
			return this.name.equals(that.name) && (this.score == that.score);
		} else {
			return false;

		}
	}

	// score �� hashCode
	@Override
	public int hashCode() {
		return Objects.hashCode(this.name) + this.score; // name ���� ������ �ִ� hashCode ( String Ÿ���̶� �ؽ��ڵ� �� �޾ƿ;ߵ�)
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Student that) {
		return this.score - that.score; // ������ : ��������, ����� : ��������
	}
}
