
/**
 *
 * @author QuanHV9
 * 2000_02_08
 *
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import entities.Dish;
import entities.Student;

/**
 * 
 */
public class App {
	public static void main(String[] args) {
		// Dish list
		List<Dish> menu = new ArrayList<>(
				Arrays.asList(new Dish(1, "pork", 200), new Dish(2, "beef", 400), new Dish(3, "chicken", 500),
						new Dish(4, "water", 20), new Dish(5, "pho", 300), new Dish(6, "banh mi", 600)));

		// Get names of menu
		List<String> threeHighCaloricDishNames = menu.stream().filter(d -> d.getCalories() > 300).map(Dish::getName)
				.limit(3).collect(Collectors.toList());
		System.out.println("--- Three High Caloric Dish Names ---");
		System.out.println(threeHighCaloricDishNames);

		// Check flow of operation
		List<String> nameDetails = menu.stream().filter(d -> {
			System.out.println("filtering " + d.getName());
			return d.getCalories() > 300;
		}).map(d -> {
			System.out.println("mapping " + d.getName());
			return d.getName();
		}).limit(3).collect(Collectors.toList());
		System.out.println("--- Stream Flow ---");
		System.out.println(nameDetails);

		// Student list
		List<Student> studentList = new ArrayList<>(Arrays.asList(new Student("1", "Nguyen An", "12/1"),
				new Student("2", "Tran Tien", "12/2"), new Student("3", "Duong Phong", "12/3"),
				new Student("4", "Hai Trieu", "12/4"), new Student("5", "Doan Tien", "12/5")));

		List<String> names = new ArrayList<>();
		// External iteration
		// Explicit iterate the list sequentially
		for (Student student : studentList) {
			// Extract the name and add to an accumulator
			names.add(student.getName());
		}
		System.out.println("--- The name of students ---");
		System.out.println(names);

		// Internal iteration
		// Executing the pipeline of operations; no iteration
		List<String> nameOfStudents = studentList.stream().map(student -> student.getName())
				.collect(Collectors.toList());
		System.out.println("--- The name of students ---");
		System.out.println(nameOfStudents);
	}
}
