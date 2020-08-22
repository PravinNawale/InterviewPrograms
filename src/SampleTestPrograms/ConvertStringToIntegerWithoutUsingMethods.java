package SampleTestPrograms;

public class ConvertStringToIntegerWithoutUsingMethods {

	public static void main(String[] args) {
		String number = "34556";
		/*
		 * convert string format of a number to number without calling
		 * Integer.parseInt() method. We can do this by converting each character into
		 * ascii format and form the number.
		 */
		char ch[] = number.toCharArray();
		int zeroAscii = (int)'0';
		System.out.println("Zero Ascii:=>"+zeroAscii);
		int sum = 0;
		for (char c : ch) {
			int tempAscii = (int)c;
			System.out.println("Character Ascii:=>"+tempAscii);
			sum = (sum*10)+(tempAscii-zeroAscii);
		}
		
		System.out.println("Intger Form:=>"+sum);
	}

}
