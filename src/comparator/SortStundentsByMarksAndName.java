package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortStundentsByMarksAndName {

	public static void main(String[] args) {

		ArrayList<StudentObject> students = new ArrayList<StudentObject>();
		students.add(new StudentObject(30,"Pravin"));
		students.add(new StudentObject(303,"Rakesh"));
		students.add(new StudentObject(30,"Amit"));
		students.add(new StudentObject(345,"Vijay"));
		Collections.sort(students, new Comparator<StudentObject>() {
			@Override
			public int compare(StudentObject arg0, StudentObject arg1) {
				if(arg0.marks == arg1.marks) {
					return (arg0.name.compareTo(arg1.name));
				} else {
					return (arg0.marks - arg1.marks);
				}
			}
		});
		System.out.println("Sorted List:=>"+students);
	}

}

class StudentObject {
	int marks;
	String name;

	public StudentObject(int marks, String name) {
		this.marks = marks;
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Student[ name="+name+", Marks="+marks+"]";
	}
}