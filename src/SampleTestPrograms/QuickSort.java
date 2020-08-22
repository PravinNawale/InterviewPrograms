package SampleTestPrograms;

public class QuickSort {

	public static void main(String[] args) {
		int numbers[] = { 2, 1, 10, 9, 3, 4, 12, 11 };
		quickSort(numbers, 0, numbers.length - 1);
		System.out.print("Sorted Array:=>");
		for(int i = 0; i < numbers.length; i++) {
			System.out.print(" " + numbers[i]);
		}
	}
	
	public static void quickSort(int numbers[], int startIndex, int endIndex) {
		if(startIndex < endIndex) {
			int partitionIndex = partition(numbers, startIndex, endIndex);
			quickSort(numbers, startIndex, partitionIndex - 1);
			quickSort(numbers, partitionIndex + 1, endIndex);
		}
	}
	
	public static int partition(int numbers[], int startIndex, int endIndex) {
		int patitionIndex = startIndex;
		int pivot = numbers[endIndex];
		for(int i = startIndex; i < endIndex; i++) {
			if(numbers[i] <= pivot) {
				int temp = numbers[i];
				numbers[i] = numbers[patitionIndex];
				numbers[patitionIndex] = temp;
				patitionIndex++;
			}
		}
		int temp = numbers[patitionIndex];
		numbers[endIndex] = numbers[patitionIndex];
		numbers[patitionIndex] = temp;
		return patitionIndex;
	}
}
