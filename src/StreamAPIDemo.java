import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class StreamAPIDemo {
	public static void main(String[] args) {
		// Khởi stream làm việc với số
		streamNumberic();
		System.out.println();
		// Các hàm làm việc với stream Numeric
		streamNumbericFunction();
		System.out.println();
		// Khởi tạo infinite stream
		infiniteStream();

	}

	public static void streamNumberic() {
		System.out.print("Int Stream: ");
		int[] numberInt = { 11, 22, 33, 44, 55, 66, 77, 88, 99, 100 };
		Arrays.stream(numberInt).forEach(element -> System.out.print(element + " "));
		System.out.println();

		System.out.print("Long Stream: ");
		long[] numberLong = { 11, 22, 33, 44, 55, 66, 77, 88, 99, 100 };
		Arrays.stream(numberLong).forEach(element -> System.out.print(element + " "));
		System.out.println();

		System.out.print("Double Stream: ");
		double[] numberDouble = { 11.1, 22.2, 33.3, 44.4, 55.5, 66.6, 77.7, 88.8, 99.9, 100 };
		Arrays.stream(numberDouble).forEach(element -> System.out.print(element + " "));
		System.out.println();
	}

	public static void streamNumbericFunction() {
		int[] numberInt = { 11, 22, 33, 44, 55, 66 };
		for (int i : numberInt) {
			System.out.print(i + " ");
		}
		System.out.println();

		// tính tổng : sum()
		int sum = Arrays.stream(numberInt).sum();
		System.out.println("Sum = " + sum);

		// tính trung bình cộng: avarage()
		double average = Arrays.stream(numberInt).average().getAsDouble();
		System.out.println("Average = " + average);

		// lấy phần tử nhỏ nhất: min()
		int min = Arrays.stream(numberInt).min().getAsInt();
		System.out.println("Mim = " + min);

		// lấy phần tử lớn nhất: min()
		int max = Arrays.stream(numberInt).max().getAsInt();
		System.out.println("Max = " + max);
	}

	public static void infiniteStream() {
		System.out.println("Tao infinite stream bang generate(): ");
		Stream<Integer> infinteStream1 = Stream.generate(() -> new Random().nextInt(100));
		infinteStream1.limit(10).mapToInt(Integer::intValue).forEach(element -> System.out.print(element + " "));

		System.out.println();
		System.out.println("Tao infinite stream bang iterate(): ");
		Stream<Integer> infinteStream2 = Stream.iterate(11, n -> n + 10);
		infinteStream2.limit(10).mapToInt(Integer::intValue).forEach(element -> System.out.print(element + " "));
	}
}