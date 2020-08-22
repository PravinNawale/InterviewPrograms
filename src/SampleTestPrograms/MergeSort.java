package SampleTestPrograms;

public class MergeSort {

	public static void main(String[] args) {
		int numbers[] = { 2, 1, 10, 9, 3, 4, 12, 11 };
		mergeSort(numbers);
		System.out.print("Sorted Array:=>");
		for(int i = 0; i < numbers.length; i++) {
			System.out.print(" " + numbers[i]);
		}
	}
	
	public static void mergeSort(int numbers[]) {
		int length = numbers.length;
		if(length < 2) {
			return;
		} else {
			int mid = length/2;
			int left[] = new int[mid];
			int right[] = new int[length-mid];
					
			for(int i = 0, k = 0; i < mid; i++, k++) {
				left[k] = numbers[i];
			}
			for(int i = mid, k = 0; i < length; i++, k++) {
				right[k] = numbers[i];
			}
			mergeSort(left);
			mergeSort(right);
			merge(left, right, numbers);
		}
	}
	
	public static void merge(int left[], int right[], int auxiliary[]) {
		int leftArrayLength = left.length;
		int rightArrayLength = right.length;
		int i = 0, j = 0, k = 0;
		while(i < leftArrayLength && j < rightArrayLength) {
			if(left[i] <= right[j]) {
				auxiliary[k] = left[i];
				i++;
			} else {
				auxiliary[k] = right[j];
				j++;
			}
			k++;
		}
		while(i < leftArrayLength) {
			auxiliary[k] = left[i];
			i++;
			k++;
		}
		while(j < rightArrayLength) {
			auxiliary[k] = right[j];
			j++;
			k++;
		}
	}
}
