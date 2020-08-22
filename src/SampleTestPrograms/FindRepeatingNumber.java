package SampleTestPrograms;

import java.util.Arrays;

public class FindRepeatingNumber {

	public static void main(String[] args) {
		int arr[] = {7, 7, 1, 2, 3, 4, 5, 6, 10, 4};
		findRepeatingNumber(arr);
	}

	private static void findRepeatingNumber(int[] arr) {
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == arr[(i+1) % arr.length]) {
				System.out.println("Repeating Number:=>"+arr[i]);
			}
		}
	}
}
