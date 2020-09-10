package SampleTestPrograms;

import java.util.stream.IntStream;

public class ArrayStoreSum {
    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        doOperation(input, 0, 0, input.length-1);
        IntStream.of(input).forEach(i -> System.out.println(i));

    }

    public static void doOperation(int[] input, int storageIndex, int startIndex, int endIndex) {
        if(storageIndex < input.length){
            input[storageIndex] = getSum(input, startIndex, endIndex);
            doOperation(input, storageIndex + 1, startIndex + 1, endIndex);
        }
    }

    private static int getSum(int[] input, int startIndex, int endIndex) {
        int sum = 1;
        for(int i=startIndex; i<endIndex; i++) {
            sum *= input[i];
        }
        return sum;
    }
}
