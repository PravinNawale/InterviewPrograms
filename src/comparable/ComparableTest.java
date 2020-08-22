package comparable;

import java.util.Arrays;

public class ComparableTest {
	public static void main(String args[]) {
		Student[] studentArr = new Student[4];
		studentArr[0] = new Student(10, "Mikey");
		studentArr[1] = new Student(20, "Arun");
		studentArr[2] = new Student(5, "Lisa");
		studentArr[3] = new Student(1, "Pankaj");
		
		Arrays.sort(studentArr);
		System.out.println("Default Sorting of Student list:\n"+Arrays.toString(studentArr));
	}
}

class Student implements Comparable<Student>{
	private int id;
	private String name;
	
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int compareTo(Student o) {
		return (this.id - o.id);
	}
	
	@Override
	public String toString() {
		return "[id=" + this.id + ", name=" + this.name +"]";
	}
}