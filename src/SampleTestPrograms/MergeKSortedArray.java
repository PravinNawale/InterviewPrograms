package SampleTestPrograms;

import java.util.TreeSet;

public class MergeKSortedArray {

    public static void main(String[] args) {
        int input[][] = { {1, 3, 5, 7},
                          {2, 4, 6, 8},
                          {0, 9, 10, 11, 15}};

        TreeSet<Integer> sortedArray = new TreeSet<>();
        // First approach
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                sortedArray.add(input[i][j]);
            }
        }

        // Second approach
        int j = 0;
        int i = 0;
        while (j < input[i].length) {
            sortedArray.add(input[i][j]);
            j++;
            if(j == input[i].length && i != input.length-1) {
                j = 0;
                i++;
            }
        }

        System.out.println("Sorted Array:=>" + sortedArray);
    }
}
