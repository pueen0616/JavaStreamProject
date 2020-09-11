package streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		//컬렉션 -> 외부반복자
		List<String> users = Arrays.asList("홍길동", "최재영", "민해주", "김상민");
		
		Iterator<String> iter = users.iterator();
		while(iter.hasNext()) {
			String str = iter.next();
			System.out.println(str.toString());
		}
		
		//스트림-> 내부반복자
		System.out.println("내부반복자 사용...");
		Stream<String> streams = users.stream();
		streams.forEach((t) -> System.out.println(t.toString())); //forEach : streams을 처리하겠다.
		}
}
