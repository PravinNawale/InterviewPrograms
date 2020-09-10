package company.zalando;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
/*
    Problem: https://www.chegg.com/homework-help/questions-and-answers/board-2-rows-n-columns-represented-matrix-m-rows-numbered-0-1-top-bottom-columns-numbered--q38897583
    https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/
    https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/discuss/710886/Java-Simple-greedy-with-pitfalls
*/
public class ZalandoTest3 {
    private static final String incorrectOutput = "IMPOSSIBLE";
    public static void main(String[] args) {
        String result = Solution(3, 2, new int[]{2, 1, 1, 0, 1});
        System.out.println(result);
    }

    public static String Solution(int U, int L, int[] C) {
        // Below program is tried by myself and gives only 24% accuracy
        /*if((U < 0 || U > 100000) || (L < 0 || L > 100000) || (C.length < 1 || C.length > 100000)){
            return "IMPOSSIBLE";
        }

        int totalSumOfC = C.length > 0 ? IntStream.of(C).sum() : 0;
        if (totalSumOfC != (U + L)) {
            return "IMPOSSIBLE";
        }

        String result = "";
        int[][] resultArray = new int[2][C.length];
        boolean flipFlag = true;
        for (int i = 0; i < C.length; i++) {
            int count = C[i];
            System.out.println("Count:=>"+count);
            if (count == 0) {
                resultArray[0][i] = 0;
                resultArray[1][i] = 0;
            } else {
                for (int j = 0; j < count; j++) {
                    if(count == 1){
                        if(flipFlag)
                        {
                            resultArray[0][i] = 1;
                            resultArray[1][i] = 0;
                            flipFlag = false;
                        } else {
                            resultArray[0][i] = 0;
                            resultArray[1][i] = 1;
                            flipFlag = true;
                        }
                    } else {
                        resultArray[0][i] = 1;
                        resultArray[1][i] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[0].length; j++) {
                result = result + resultArray[i][j] ;
            }
            result = result + ",";
        }
        return result.substring(0, result.length()-1);*/

        // Below program gives 76% accuracy
        if((U < 0 || U > 100000) || (L < 0 || L > 100000) || (C.length < 1 || C.length > 100000)){
            return incorrectOutput;
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> upperList = new ArrayList<>(), lowerList = new ArrayList<>();
        int diff = U - L, sum = 0;
        for (int number : C) {
            if(number<0 || number>2){
                return incorrectOutput;
            }
            sum += number;
            if (number % 2 == 0) {
                upperList.add(number / 2);
                lowerList.add(number / 2);
            } else {
                if (diff >= 0) {
                    upperList.add(1);
                    lowerList.add(0);
                    diff--;
                } else {
                    upperList.add(0);
                    lowerList.add(1);
                    diff++;
                }
            }
        }
        if (diff != 0 || U + L != sum){
            return res.size()==0 ? incorrectOutput : getFormattedOutput(res);
        }
        res.add(upperList);
        res.add(lowerList);
        return res.size()==0 ? incorrectOutput : getFormattedOutput(res);
    }

    public static String getFormattedOutput(List<List<Integer>> res){
        // Better use String builder to improve the performance
        String output = "";
        for(int index = 0; index < res.size(); index++){
            List<Integer> innerList = res.get(index);
            for(int innerIndex = 0; innerIndex < innerList.size(); innerIndex++){
                output = output  + innerList.get(innerIndex);
            }
            output = output + ",";
        }
        return output.substring(0, output.length()-1);
    }
}
