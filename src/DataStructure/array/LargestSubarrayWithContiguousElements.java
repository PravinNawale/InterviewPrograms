package DataStructure.array;

public class LargestSubarrayWithContiguousElements {

	public static void main(String[] args) {

		int arr[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int size = arr.length;
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

		for (int i = 0; i < size; i++) {
			max_ending_here = max_ending_here + arr[i];
			if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
			if (max_ending_here < 0)
				max_ending_here = 0;
		}
		System.out.println("max:=>" + max_so_far);
		
		int sum = 0;
		for (int i = 0; i < size; i++) {
			int temp = arr[i];
			String te = arr[i]+" ";
			for (int j = i+1; j < size; j++) {
				te = te + arr[j] + " ";
				temp = temp + arr[j];
				System.out.print("\nSubArray[ "+ te +" ] :=>"+temp);
				if(temp>sum) {
					sum = temp;
				}
			}
		}
		System.out.println("Largest Sum:=>"+sum);
	}
}
