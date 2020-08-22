package SampleTestPrograms;

import java.util.*;

public class FindSubsequenceWhoseSumIsEqualToK {
    /*
        Input: arr[] = {1, 2, 3}, K = 3
        Output:
        1 2
        3
     */
    public static void main(String[] args) {
        int input[] = {1, 2, 3};
        int k = 3;
        int rotateCount = 1;
        List<LinkedList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < input.length; i++) {
            LinkedList<Integer> subSequence = new LinkedList<>();
            subSequence.add(input[i]);
            for(int j = i+1; j < input.length; j++) {
                subSequence.add(input[j]);
            }
            if(rotateCount != input.length && i == input.length-1){
                i = 0;
                rotateCount++;
                input = rotateArray(input);
            }
            //if(subSequence.stream().mapToInt(Integer::intValue).sum() == k){
                list.add(subSequence);
            //}
        }
        System.out.println("All the possible subsequences whose sum is equal to k:=> "+list);
    }

    public static int[] rotateArray(int[] array) {
        int[] output = new int[array.length];
        int end = array[array.length-1];
        for(int k=output.length-1;k>0;k--) {
            output[k] = output[k-1];
        }
        output[0] = end;
        return output;
    }
}
