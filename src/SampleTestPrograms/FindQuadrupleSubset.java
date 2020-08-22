package SampleTestPrograms;

/*
 * find a quadruple subset of an array such that the sum of 1st 2 nos. is equal to the sum of other 2
 */
public class FindQuadrupleSubset {
	public static void main(String[] args) {
		int arr[] = {4, 13, 3, 4, 7, 7, 7, 7, 1, 2, 9, 8, 1, 16};
		int arrayLength = arr.length;
		for(int i=0;i<arrayLength;i++) {
			int first = arr[i];
			int second = arr[(i+1)%arrayLength];
			int third = arr[(i+2)%arrayLength];
			int fourth = arr[(i+3)%arrayLength];
			if((first+second) == (third+fourth)) {
				System.out.println("QuadruplesSubset:["+ first + "," + second + "," + third + "," + fourth +"]");
			}
		}
	}
}