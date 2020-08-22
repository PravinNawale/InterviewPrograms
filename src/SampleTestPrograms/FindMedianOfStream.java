package SampleTestPrograms;

import java.util.ArrayList;
import java.util.Arrays;

public class FindMedianOfStream {
	public static void main(String args[]) {
		ArrayList<Integer[]> streams = new ArrayList<Integer[]>();
		streams.add(new Integer[]{2,4,5,7,8,9,4,3,2});
		streams.add(new Integer[]{2,4,5,9,4,3,2});
		streams.add(new Integer[]{2,4,343,7,8,9,4,3,2});
		streams.add(new Integer[]{2,4,5,8,9,3,2});
		streams.add(new Integer[]{2,8,9,4,3,2});
		streams.add(new Integer[]{1,1,1,1});
		
		for (Integer[] integers : streams) {
			findMedian(integers);
		}
	}
	//223445789
	private static void findMedian(Integer[] stream) {
		Arrays.sort(stream);
		int median = stream[stream.length/2];
		System.out.println("Median:=>"+median);
	}
}
