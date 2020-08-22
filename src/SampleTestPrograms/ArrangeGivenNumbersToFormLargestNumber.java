package SampleTestPrograms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrangeGivenNumbersToFormLargestNumber {

    public static void main(String args[]) {
        Integer numbers[] = {1, 34, 3, 98, 9, 76, 45, 4, 12, 121};
        // Output should be 99876454343121211
        List<Integer> numbersList = Arrays.asList(numbers);
        findLargestNumber(numbersList);
    }

    private static void findLargestNumber(List<Integer> numbersList) {
        Collections.sort(numbersList, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                String xy = x + "" + y;
                String yx = y + "" + x;
                return xy.compareTo(yx) > 0 ? -1 : 1;
            }
        });
        numbersList.forEach(number -> System.out.print(number));
    }
}
