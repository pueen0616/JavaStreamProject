package streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		//�÷��� -> �ܺιݺ���
		List<String> users = Arrays.asList("ȫ�浿", "���翵", "������", "����");
		
		Iterator<String> iter = users.iterator();
		while(iter.hasNext()) {
			String str = iter.next();
			System.out.println(str.toString());
		}
		
		//��Ʈ��-> ���ιݺ���
		System.out.println("���ιݺ��� ���...");
		Stream<String> streams = users.stream();
		streams.forEach((t) -> System.out.println(t.toString())); //forEach : streams�� ó���ϰڴ�.
		}
}
