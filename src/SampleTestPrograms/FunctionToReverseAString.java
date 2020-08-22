package SampleTestPrograms;

public class FunctionToReverseAString {

	public static void main(String[] args) {
		String string = "253sdgsgsdgsdg";
		System.out.println("Reversed String:=>" + reverseString(string));
		System.out.println("Reversed String:=>" + reverseString2(string));
	}

	private static String reverseString(String string) {
		String reversedString = "";
		char[] charArray = string.toCharArray();

		for (int i = charArray.length - 1; i >= 0; i--)
			reversedString = reversedString + charArray[i];
		
		return reversedString;
	}

	private static String reverseString2(String string) {
		return new StringBuilder(string).reverse().toString();
	}
}
