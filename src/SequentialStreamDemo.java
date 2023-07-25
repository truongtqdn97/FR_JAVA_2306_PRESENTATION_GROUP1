import java.util.*;
import java.util.concurrent.TimeUnit;

public class SequentialStreamDemo {

	public static void main(String[] args) {
		// Khởi tạo list chứa 18000 số nguyên
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 18000; i++) {
			list.add(i);
		}
		long startTime = System.nanoTime();
		// Sử dụng sequential stream để in ra các phần tử của list
		list.stream().forEach(System.out::print);
		long endTime = System.nanoTime();
		long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
		System.out.println(String.format("\nSequential stream took: %d ms", millis));

	}
}
