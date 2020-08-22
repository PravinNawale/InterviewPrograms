package SampleTestPrograms;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortArrayWithoutUsingSort {

	public static void main(String[] args) {
		System.out.println("Before:=>"+Runtime.getRuntime().totalMemory());
		SortedSet<String> set = new TreeSet<String>();

		String[] s = { "this", "will", "be", "sorted", "without", "any", "sort()", "function", "or", "comparator" };
		// Add elements to the set

		for (int i = 0; i < s.length; i++) {
			set.add(s[i]);
		}
		// Iterating over the elements in the set
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			// Get element
			Object element = it.next();
			System.out.println(element.toString());
		}
		
		System.out.println("After:=>"+Runtime.getRuntime().totalMemory());
	}
}
