package SampleTestPrograms;

import java.util.HashMap;

public class ConvertRomanNumbersToDecimal {
	static HashMap<String, Integer> romanMap = new HashMap<String, Integer>();

	public static void main(String[] args) {
		String romanNumner = "MCMIV";
		romanMap.put("I", 1);
		romanMap.put("IV", 4);
		romanMap.put("V", 5);
		romanMap.put("IX", 9);
		romanMap.put("X", 10);
		romanMap.put("XL", 40);
		romanMap.put("L", 50);
		romanMap.put("XC", 90);
		romanMap.put("C", 100);
		romanMap.put("CD", 400);
		romanMap.put("D", 500);
		romanMap.put("CM", 900);
		romanMap.put("M", 1000);

		System.out.println("Integer form of Roman Numeral is :=>" + getDecimalValueForRomanNumber(romanNumner));
	}

	public static int getDecimalValueForRomanNumber(String romanNumber) {
		int result = 0;
		for (int i = 0; i < romanNumber.length(); i++) {
			// Getting value of symbol s[i]
			System.out.println("Test"+i);
			int s1 = romanMap.get(romanNumber.charAt(i));

			// Getting value of symbol s[i+1]
			if (i + 1 < romanNumber.length()) {
				int s2 = romanMap.get(romanNumber.charAt(i + 1));

				// Comparing both values
				if (s1 >= s2) {
					// Value of current symbol is greater
					// or equalto the next symbol
					result = result + s1;
				} else {
					result = result + s2 - s1;
					i++; // Value of current symbol is
					// less than the next symbol
				}
			} else {
				result = result + s1;
				i++;
			}
		}
		return result;
	}
}
