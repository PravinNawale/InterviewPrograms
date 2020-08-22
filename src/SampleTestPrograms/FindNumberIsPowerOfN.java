package SampleTestPrograms;

public class FindNumberIsPowerOfN {

	public static void main(String[] args) {
		int number = 450;
		int power = 2;

		if ((number % power) == 0) {
			System.out.println("Number is Power of " + power);
		} else {
			System.out.println("Number is not Power of " + power);
		}
	}
}
