/**
 *
 * @author QuanHV9
 * 2000_02_08
 *
 */
package entities;

/**
 * 
 */
public class Dish {
	private int id;
	private int calories;
	private String name;
	
	public Dish() {}
	
	/**
	 * @param calory
	 * @param name
	 */
	public Dish(int id, String name, int calories) {
		super();
		this.id = id;
		this.calories = calories;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calory) {
		this.calories = calory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Dish [calories=" + calories + ", name=" + name + "]";
	}
}
