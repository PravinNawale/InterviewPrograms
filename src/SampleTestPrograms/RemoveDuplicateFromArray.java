package SampleTestPrograms;

import java.util.HashSet;

public class RemoveDuplicateFromArray {

	public static void main(String[] args) {
		int[] elements = {2,5,6,6,6,6,7,8,5,3,2,4,5,6,7,8,9,9,90,1};
		
		System.out.println("Unique Array:=>"+ removeDuplicates(elements));
	}
	
	public static HashSet<Integer> removeDuplicates(int[] elements){
		HashSet<Integer> unique = new HashSet<Integer>();
		for(int i=0;i<elements.length;i++) {
			unique.add(elements[i]);
		}
		return unique;
	}
	
}
