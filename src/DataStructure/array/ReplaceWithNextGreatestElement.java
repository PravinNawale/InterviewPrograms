package DataStructure.array;

import java.util.Arrays;

public class ReplaceWithNextGreatestElement {

	public static void main(String[] args) {
		int arr[] = {16, 17, 4, 3, 5, 2}; 
        nextGreatest (arr); 
        Arrays.sort(arr);
        System.out.println("The modified array:"); 
        printArray (arr); 
	}
	
	private static void nextGreatest(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int temp = arr[i];
			for(int j=i;j<arr.length;j++) {
				if(arr[j]>temp) {
					arr[i] = arr[j];
					break;
				}
			}
		}
	}
	
	static void printArray(int arr[]) 
    { 
        for (int i=0; i < arr.length; i++) 
        System.out.print(arr[i]+" "); 
    } 
}
