package SampleTestPrograms;

public class FindRowWithMax1s {

    public static void main(String[] args) {

        int matrix[][] = {  { 0, 0, 0, 1, 1 },
                            { 1, 1, 0, 0, 1 },
                            { 1, 1, 1, 1, 0 },
                            { 0, 0, 0, 0, 1 }  };

        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
        int maxOnesIndex = -1;
        int max = 0;
        for(int i=0; i<rowCount; i++) {
            int rowOnesCount = 0;
            for(int j=0; j<columnCount; j++) {
                if(matrix[i][j] == 1) {
                    rowOnesCount++;
                }
            }
            if(rowOnesCount > max) {
                max = rowOnesCount;
                maxOnesIndex = i;
            }
        }
        System.out.println("Max 1 Index is:=>" + maxOnesIndex);
    }
}
