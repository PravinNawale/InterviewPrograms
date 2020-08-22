package DataStructure.array;

public class MagicArray {
	public static void main(String[] args) {
		
		int n=7;
		int[][] magic = new int[n][n];
		
		int row = 0;
		int col = n / 2;
		int square = n * n;
		
		for (int i = 1; i <= square; i++) {
			magic[row][col] = i;
			if (i % n == 0)
				row++;
			else {
				if (row == 0)
					row = n - 1;
				else
					row--;
				
				if (col == (n - 1))
					col = 0;
				else
					col++;
			}
		}
		
		System.out.println("The Magic Square for "+n+":"); 
        System.out.println("Sum of each row or column "+n*(n*n+1)/2+":"); 
        for(int i=0; i<n; i++) 
        { 
            for(int j=0; j<n; j++) 
                System.out.print(magic[i][j]+" "); 
            System.out.println(); 
        } 
	}
}
