package SampleTestPrograms;

public class RotateMatrixBy90Degree {
    public static void main(String[] args) {
        int input[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        /* output should be
        13 9 5 1
        14 10 6 2
        15 11 7 3
        16 12 8 4 */

        int[][] output = rotateBy90(input);
        printMatrix(output);
    }

    public static int[][] rotateBy90(int input[][]) {
        int output[][] = new int[input[0].length][input.length];
        for (int i = 0, k = input.length - 1; i < input.length; i++, k--) {
            for (int j = 0; j < input[0].length; j++) {
                output[j][k] = input[i][j];
            }
        }
        return output;
    }

    public static void printMatrix(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}
