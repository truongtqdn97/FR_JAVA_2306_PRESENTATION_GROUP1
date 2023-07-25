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
public class Student {
	private String id;
	private String name;
	private String iClass;
	
	public Student() {}
	
	/**
	 * @param id
	 * @param name
	 * @param iClass
	 */
	public Student(String id, String name, String iClass) {
		super();
		this.id = id;
		this.name = name;
		this.iClass = iClass;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getiClass() {
		return iClass;
	}
	public void setiClass(String iClass) {
		this.iClass = iClass;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", iClass=" + iClass + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		
		if (!(obj instanceof Student)) {
			return false;
		}
		Student other = (Student) obj;
		boolean isEqualId = (this.id == null && other.getId() == null) || (this.id != null && this.id.equals(other.getId()));
		boolean isEqualName = (this.name == null && other.getName() == null) || (this.name != null && this.name.equals(other.getName()));
		boolean isEqualClass = (this.iClass == null && other.getClass() == null) || (this.iClass != null && this.iClass.equals(other.getiClass()));
		return isEqualId && isEqualName && isEqualClass;
	}
	
	
	
}
