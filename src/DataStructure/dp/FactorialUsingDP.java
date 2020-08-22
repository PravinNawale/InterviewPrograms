package DataStructure.dp;

public class FactorialUsingDP {
	
	static int[] arrDP = new int[6];
	static {
		arrDP[0] = 1;
		arrDP[1] = 1;
	}
	public static void main(String arg[]) {
		int factNumber = 5;
		System.out.println("Factorial Using Recursion:=>"+findFactUsingRecursion(factNumber));
		System.out.println("Factorial Using DP:=>"+findFactUsingDP(factNumber));
	}
	
	/*
	 * Using the Dynamic Programming + Recursion
	 */
	private static int findFactUsingDP(int factNumber) {
		if(arrDP[factNumber]!=0) {
			return arrDP[factNumber];
		} else {
			arrDP[factNumber] = factNumber * findFactUsingDP(factNumber-1);
			return arrDP[factNumber];
		}
	}
	
	/*
	 * Using the Normal Recursion Program
	 */
	private static int findFactUsingRecursion(int factNumber) {
		if(factNumber == 0 || factNumber == 1) {
			return 1;
		}
		return factNumber * findFactUsingRecursion(factNumber-1);
	}
}
