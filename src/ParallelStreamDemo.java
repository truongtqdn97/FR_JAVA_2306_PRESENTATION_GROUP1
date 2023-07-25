import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * TrungNH52 - 19/04/1999
 */
public class ParallelStreamDemo {
	public static void main(String[] args) {
		// Khởi tạo list chứa 18000 số nguyên
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 18000; i++) {
			list.add(i);
		}
		long startTime = System.nanoTime();
		// Sử dụng parallel stream để in ra các phần tử của list
		list.parallelStream().forEach(System.out::print);
		long endTime = System.nanoTime();
		long millis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
		System.out.println(String.format("\nParallel stream took: %d ms", millis));
	}
}
