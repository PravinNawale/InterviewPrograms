package SampleTestPrograms;

import java.util.ArrayList;
import java.util.List;

public class ArrayListQuestions {
	public static void main(String[] args) {
		List list = new ArrayList<>(100);
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		System.out.println("List:=>"+list);
		list.add(10,"7");
		System.out.println("List:=>"+list);
	}
}