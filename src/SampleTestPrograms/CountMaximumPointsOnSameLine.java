package SampleTestPrograms;

public class CountMaximumPointsOnSameLine {
	/*
	 * Input : points[] = {-1, 1}, {0, 0}, {1, 1}, {2, 2}, {3, 3}, {3, 4} Output : 4
	 * Then maximum number of point which lie on same line are 4, those point are
	 * {0, 0}, {1, 1}, {2, 2}, {3, 3}
	 */
	public static void main(String[] args) {
		int[][] points = {
				{-1, 1}, 
				{0, 0}, 
				{1, 1}, 
				{2, 2}, 
				{3, 3}, 
				{3, 4}};
		System.out.println("Length:=>"+points.length);
		System.out.println("Length:=>"+(6*(6-1))/2);
	}
}
