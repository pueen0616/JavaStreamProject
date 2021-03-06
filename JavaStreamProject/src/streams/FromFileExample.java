package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromFileExample {
	public static void main(String[] args) {
		String file = "src/streams/StreamExample2.java";
		Path path = Paths.get(file);
		try {
			Stream<String> stream = Files.lines(path);
			stream.forEach(s -> System.out.println(s));
			stream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
