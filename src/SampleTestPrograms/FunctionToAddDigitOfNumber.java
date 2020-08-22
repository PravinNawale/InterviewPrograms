package SampleTestPrograms;

public class FunctionToAddDigitOfNumber {

	public static void main(String[] args) {
		int number = 456;
		System.out.println("Sum of Digits of Numbers:=>" + addDigitOfNumber(number));
	}

	private static int addDigitOfNumber(int number) {
		int sum = 0, lastDigit = 0;

		while (number > 0) {
			lastDigit = number % 10;
			sum = sum + lastDigit;
			number = number / 10;
		}
		return sum;
	}
}
