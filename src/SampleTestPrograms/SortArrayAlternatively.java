package SampleTestPrograms;

import java.util.Arrays;

public class SortArrayAlternatively {

	public static void main(String[] args) {
		int arr[] = {7, 1, 2, 3, 4, 5, 6, 10};
		sortArrayAlternatively(arr);
	}

	private static void sortArrayAlternatively(int[] arr) {
		 Arrays.sort(arr);
		 int length = arr.length;
		 for(int i=0,j=length-1;i<length;i++,j--) {
			 if(i<j) {
				 System.out.print(" "+arr[j]+" "+arr[i]);
			 }
			 if(i==j) {
				 System.out.print(" "+arr[j]);
			 }
		 }
	}
}
