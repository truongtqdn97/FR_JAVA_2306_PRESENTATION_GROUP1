import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamInitilization {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Khởi tạo stream từ collection.
		// Khai báo list
		ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		// Tạo stream thông qua stream();
		Stream<Integer> intStream = intList.stream();
		// Tạo stream thông qua parallelStream();
		Stream<Integer> intParallelStream = intList.parallelStream();

		// Khai báo set
		HashSet<Integer> intSet = new HashSet<>(intList);
		// Tạo stream thông qua stream();
		Stream<Integer> intSetStream = intSet.stream();
		// Tạo stream thông qua parallelStream();
		Stream<Integer> intSetParallelStream = intSet.parallelStream();

		// Khởi tạo stream từ một mảng
		// Khai báo mảng chứa các chuổi
		String[] stringArray = new String[] { "Trường", "Đức", "Trung", "Kiệt" };
		// Khởi tạo stream bằng Arrays.stream()
		Stream<String> stringStream = Arrays.stream(stringArray);

		// Khởi tạo stream đối với map
		// Khai báo map
		HashMap<Integer, String> intStrMap = new HashMap<Integer, String>();
		intStrMap.put(1, "A");
		intStrMap.put(2, "B");
		intStrMap.put(3, "C");

		// Sử dụng entrySet() để khởi tạo set chứa các entry trong map
		Set<Entry<Integer, String>> entrySet = intStrMap.entrySet();
		// Khởi tạo stream từ entry set tương ứng
		Stream<Entry<Integer, String>> entryStream = entrySet.stream();

		// Sử dụng keySet() để khởi tạo set chứa các key trong map
		Set<Integer> keySet = intStrMap.keySet();
		// Khởi tạo stream từ key set tương ứng
		Stream<Integer> keyStream = keySet.stream();

		// Sử dụng values() để lấy ra collection các values trong map
		Collection<String> valuesList = intStrMap.values();
		// Khởi tạo stream từ collection các values
		Stream<String> valueStream = valuesList.stream();

		// Khởi tạo stream bằng Factory Init
		// Stream.of(Object []) - khởi tạo stream từ mảng chứa các chuỗi ký tự.
		Stream<String> intFacStream = Stream.of(new String[] { "ABC", "DEF", "GHI" });

		// Khởi tạo stream chứa các số nguyên từ 10 - 20
		IntStream intRangeStream = IntStream.range(10, 20);
		// Khởi tạo stream chứa các số nguyên kiểu long từ 10 - 20
		LongStream longRangeStream = LongStream.range(10l, 20l);

		// Stream.iterate(Object,UnaryOperator)
		// Khởi tạo chứa các số tăng dần từ 1, tối đa 10 phần tử
		Stream<Integer> intIterateStream = Stream.iterate(1, n -> n + 1).limit(10);

		// Khởi tạo stream chứa các sô ngẫu nhiên từ 0 - 9 tối đa 15 phần tử.
		Stream<Integer> intGenerateStream = Stream.generate(() -> new Random().nextInt(10)).limit(15);
	}
}