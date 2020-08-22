package company.zalando;

import java.util.Stack;

/*
    Problem: https://github.com/galaumang/problemsolving-delete/blob/master/src/main/java/org/swaarg/problemsolving/array/NextGreaterNumber.java
*/
public class ZalandoTest1 {
    public static void main(String[] args) {
        int result = solution(0);
    }

    public static int solution(int N) {
        int result = N;
        /*
            Since there are no solid rule given about the return value for the below range
            hence i am returning the N as it is.
         */
        if(N < 1 || N > 50000) {
            return N;
        }
        Stack<Integer> digitsStack = getTotalDigits(result);
        final int totalDigitSum = digitsStack.stream().mapToInt(a->a).sum();
        boolean isSmallestNumberFound = false;
        int count = 1;
        while (!isSmallestNumberFound) {
            int nextNumber = result + count;
            digitsStack.clear();
            digitsStack = getTotalDigits(nextNumber);
            int totalDigitSumForNextElement = digitsStack.stream().mapToInt(a->a).sum();
            if (totalDigitSumForNextElement == totalDigitSum) {
                isSmallestNumberFound = true;
                result = nextNumber;
            }
            count++;
        }
        return result;
    }

    public static Stack<Integer> getTotalDigits(int input) {
        final Stack<Integer> digitsStack = new Stack<>();
        while(input != 0) {
            final int digit = input % 10;
            input = input / 10;
            digitsStack.push(digit);
        }
        return digitsStack;
    }
}
