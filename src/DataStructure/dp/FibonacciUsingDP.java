package DataStructure.dp;

public class FibonacciUsingDP {
	
	static int[] arrDP = new int[8+1];
	static {
		arrDP[0] = 1;
		arrDP[1] = 1;
	}
	
	public static void main(String[] args) {
		int number = 8;
		System.out.println("Fibonacci Using Recursion:=>"+findFibonacciUsingRecursion(number));
		System.out.println("Fibonacci Using DP:=>"+findFibonaccUsingDP(number));
	}

	private static int findFibonaccUsingDP(int number) {
		if(number == 0 || number == 1) {
			return 1;
		}
		if(arrDP[number]!=0) {
			return arrDP[number];
		}
		return arrDP[number] = findFibonacciUsingRecursion(number-1) + findFibonacciUsingRecursion(number -2);
	}

	private static int findFibonacciUsingRecursion(int number) {
		if(number == 0 || number == 1) {
			return 1;
		}
		return findFibonacciUsingRecursion(number-1) + findFibonacciUsingRecursion(number -2);
	}
}
