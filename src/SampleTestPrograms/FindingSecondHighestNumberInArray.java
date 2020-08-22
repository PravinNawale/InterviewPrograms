package SampleTestPrograms;

import java.util.Arrays;
import java.util.HashMap;

public class FindingSecondHighestNumberInArray {

	public static void main(String[] args) {
		 int arr[] = {1, 5, 2, 1, 3, 2, 1};
		 Arrays.sort(arr);
		 HashMap<Integer,Integer> countMap = new HashMap<>();
		 for(int i=0;i<arr.length;i++) {
			 if(!countMap.containsKey(arr[i])) {
				 countMap.put(arr[i], 1);
			 }else {
				 countMap.put(arr[i], countMap.get(arr[i])+1);
			 }
		 }
		 
		 System.out.println("Count:"+countMap);
		 
		 //Write a logic to return the second highest
	}
}
