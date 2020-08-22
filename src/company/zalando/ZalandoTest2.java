package company.zalando;

/*
    Problem: https://github.com/galaumang/problemsolving-delete/blob/master/src/main/java/org/swaarg/problemsolving/array/FairIndexes.java
*/
public class ZalandoTest2 {
    public static void main(String[] args) {
        int[] A = {4, -1, 0, 3};
        int[] B = {-2, 5, 0, 3};
        int fairIndices = fairIndices(A, B);
        System.out.println(fairIndices);
    }

    /**
     * @param A firstArray
     * @param B secondArray
     * @return number of fair Indexes
     */
    public static int fairIndices(int[] A, int[] B) {
        final int length = A.length;
        /*
            Since there is no rule given for the return value for the below range i am assuming and
            returning the -1 for that case.
         */
        if(length < 2 || length > 100000) {
            return -1;
        }
        // Store the incremental sum of 2 array elements
        final int[] incrementalSumArrayA = new int[length + 1];
        final int[] incrementalSumArrayB = new int[length + 1];
        int noOfFairIndexes = 0;
        boolean shouldRunFurtherLogic = true;
        for(int index = 1; index <= length; index++) {
            if ((A[index-1] < -1000000000 || A[index-1] > 1000000000)
                || (B[index-1] < -1000000000 || B[index-1] > 1000000000)) {
                // Assuming when the array inputs are invalid returing the indexes as -1
                noOfFairIndexes = -1;
                shouldRunFurtherLogic = false;
            }
            incrementalSumArrayA[index] = incrementalSumArrayA[index - 1] + A[index - 1];
            incrementalSumArrayB[index] = incrementalSumArrayB[index - 1] + B[index - 1];
        }
        if(shouldRunFurtherLogic) {
            for(int index = 1; index < length; index++) {
                if(incrementalSumArrayA[index] == incrementalSumArrayB[index]
                    && incrementalSumArrayA[index] == incrementalSumArrayA[length] - incrementalSumArrayA[index]
                    && incrementalSumArrayB[index] == incrementalSumArrayB[length] - incrementalSumArrayB[index])
                {
                    noOfFairIndexes++;
                }
            }
        }
        return noOfFairIndexes;
    }
}
