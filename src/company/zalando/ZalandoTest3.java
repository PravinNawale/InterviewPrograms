package company.zalando;

import java.util.stream.IntStream;
/*
    Problem: https://www.chegg.com/homework-help/questions-and-answers/board-2-rows-n-columns-represented-matrix-m-rows-numbered-0-1-top-bottom-columns-numbered--q38897583
*/
public class ZalandoTest3 {
    public static void main(String[] args) {
        String result = Solution(3, 2, new int[]{2, 1, 1, 0, 1});
        System.out.println(result);
    }

    public static String Solution(int U, int L, int[] C) {
        if((U < 0 || U > 1000000) || (L < 0 || L > 1000000) || (C.length < 1 || C.length > 1000000)){
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
        return result.substring(0, result.length()-1);
    }
}
