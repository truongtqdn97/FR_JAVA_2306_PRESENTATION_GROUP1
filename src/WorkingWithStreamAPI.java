import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WorkingWithStreamAPI {
	private static void filterStream() {
		Stream<String> source = Stream.of("java", "nodejs", "hot girl");
		Stream<String> result = source.filter(line -> !"hot girl".equals(line)); // we dont like hot girl
		System.out.println("filter(): ");
		result.forEach(System.out::println); // output : java, nodejs
		System.out.println("----------------------");

		Stream<String> family = Stream.of("wife", "wife", "son", "daughter");
		family = family.distinct();
		System.out.println("distinct(): ");
		family.forEach(System.out::println);// wife, son, daughter
		System.out.println("----------------------");
	}

	private static void slideStream() {
		// limit()
		Stream<Integer> numbers1 = Stream.of(1, 2, 3, 4, 5);
		Stream<Integer> slicedNumbers1 = numbers1.limit(3); // limit 3 elements
		System.out.println("limit(): ");
		slicedNumbers1.forEach(System.out::println); // output: 1, 2, 3
		System.out.println("----------------------");

		// skip()
		Stream<Integer> numbers2 = Stream.of(1, 2, 3, 4, 5);
		Stream<Integer> slicedNumbers2 = numbers2.skip(2); // skip 2 elements
		System.out.println("skip(): ");
		slicedNumbers2.forEach(System.out::println); // output: 3, 4, 5
		System.out.println("----------------------");

		// limit() and skip()
		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
		Stream<Integer> slicedNumbers = numbers.skip(2).limit(2);
		// skip 2 elements, limit 2 elements
		System.out.println("skip() and limit(): ");
		slicedNumbers.forEach(System.out::println); // output: 3, 4
		System.out.println("----------------------");
	}

	private static void matchStream() {
		// allMatch()
		Stream<Integer> numbers1 = Stream.of(1, 2, 3, 4, 5);
		boolean allEven = numbers1.allMatch(n -> n % 2 == 0); // check even
		System.out.println("allMatch(): ");
		System.out.println(allEven); // false
		System.out.println("----------------------");

		// anyMatch()
		Stream<Integer> numbers2 = Stream.of(1, 2, 3, 4, 5);
		boolean anyEven = numbers2.anyMatch(n -> n % 2 == 0); // check even
		System.out.println("anyMatch(): ");
		System.out.println(anyEven); // true
		System.out.println("----------------------");

		// noneMatch()
		Stream<Integer> numbers3 = Stream.of(1, 2, 3, 4, 5);
		boolean noneNegative = numbers3.noneMatch(n -> n < 0); // check negative
		System.out.println("noneMatch()");
		System.out.println(noneNegative); // true
		System.out.println("----------------------");
	}

	private static void findStream() {
		// findFirst()
		Stream<Integer> numbers1 = Stream.of(1, 2, 3, 4, 5);
		Optional<Integer> firstNumber = numbers1.findFirst();
		System.out.println("findFirst(): ");
		if (firstNumber.isPresent()) {
			System.out.println(firstNumber.get()); // 1
		} else {
			System.out.println("empty");
		}
		System.out.println("----------------------");

		// findAny()
		Stream<Integer> numbers2 = Stream.of(1, 2, 3, 4, 5);
		Optional<Integer> number = numbers2.findAny();
		System.out.println("findAny(): ");
		if (number.isPresent()) {
			System.out.println(number.get()); // 1
		} else {
			System.out.println("empty");
		}
		System.out.println("----------------------");
	}

	private static void reduceStream() {
		Stream<Integer> numbers1 = Stream.of(1, 2, 3, 4, 5);
		// use reduce() to sum
		int sum = numbers1.reduce(0, (subTotal, element) -> subTotal + element);// 15
		System.out.println("use reduce() to sum: " + sum);

		// use reduce() to find max num
		Stream<Integer> numbers2 = Stream.of(1, 2, 3, 4, 5);
		Optional<Integer> max = numbers2.reduce((a, b) -> a > b ? a : b);// 5
		System.out.println("use reduce() to find max number: " + max.get());

		System.out.println("----------------------");
	}

	private static void mapStream() {
		Stream<Integer> numbers1 = Stream.of(1, 2, 3, 4, 5);
		// use map() to calculate square number
		Stream<Integer> squareNumbers = numbers1.map(num -> num * num); // 1 4 9 16 25
		System.out.println("use map() to calculate square number: ");
		squareNumbers.forEach(System.out::println);

		// flatMap()
		List<List<Integer>> numbers = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));

		List<Integer> flattenedNumbers = numbers.stream().flatMap(List::stream).collect(Collectors.toList());
		System.out.println("flatMap(): ");
		System.out.println(flattenedNumbers);
		System.out.println("----------------------");
	}

	public static void main(String[] args) {
		filterStream();
		slideStream();
		matchStream();
		findStream();
		reduceStream();
		mapStream();
	}
}
