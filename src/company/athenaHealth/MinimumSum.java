package company.athenaHealth;

import java.util.*;

public class MinimumSum {
    /*
        Given an Array of an integer, perform some number K of operations. Each operation consists of removing any element
        from the array, divide it by 2 and inserting and ceiling of that result back into array.
        Minimize the sum of the elements in the final array.
     */
    public static void main(String[] args) {
        int[] input = { 10, 20, 7};
        int sum = minimalSum(input, 4);
        System.out.println(sum);
    }

    public static int minimalSum(int[] input, int ktests) {
        List<Integer> data = new ArrayList<>();
        for(int i=0; i< input.length; i++) {
            data.add(input[i]);
        }
        if (data.size() == 0) {
            return 0;
        }
        int index = 0;
        int max = Integer.MAX_VALUE;
        System.out.println("Initial max :=>" + max);
        while (ktests > 0) {
            System.out.println("Data " + ktests + ":=>" + data);
            int currentValue = data.get(index);
            System.out.println("currentValue " + ktests + ":=>" + currentValue);
            System.out.println("max " + ktests + ":=>" + max);
            if (currentValue <= max) {
                data.sort(Comparator.reverseOrder());
                System.out.println("Data Sorted " + ktests + ":=>" + data);
                index = 0;
                max = data.get(0) / 2;
                System.out.println("max inside if " + ktests + ":=>" + max);
                continue;
            }
            System.out.println("Normal flow :" + ktests);
            ktests--;

            int roundUp = currentValue & 1;
            System.out.println("Roundedup Value " + ktests + ":=>" + roundUp);
            currentValue /= 2;
            System.out.println("currentValue /= 2 " + currentValue);
            currentValue += roundUp;
            System.out.println("currentValue += roundUp " + currentValue);

            data.set(index, currentValue);
            if (index + 1 < data.size()) {
                index++;
            }
        }
        System.out.println("data:=>" + data);
        return data.stream().mapToInt(a->a).sum();
    }
}
