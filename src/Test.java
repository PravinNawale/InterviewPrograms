/*public class Test {
    public static void main(String[] args) {
        n_squares(1000);
    }

    static String n_squares(int n) {
        StringBuffer s = new StringBuffer("0");
        int n_squared = n*n;
        for (int i=0; i<n_squared; i++) {
            s.append (", " + i);
        }
        return s.toString();
    }
}*/

import java.util.*;

class Task implements Runnable {
    private void do_stuff() {
        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {}
    }
    public void run() {
        do_stuff();
    }

    public static void main(String[] args) {
/*        Thread[] task_array = {new Thread(new Task()),
                new Thread(new Task()),
                new Thread(new Task()),
                new Thread(new Task())};
        task_array[0].start();
        task_array[1].start();
        task_array[2].run();
        task_array[3].run();
        System.out.println("Done");*/

        /*Set<Integer> cache = new LinkedHashSet<>(3);
        cache.add(3);
        cache.add(2);
        cache.add(7);
        cache.add(6);
        System.out.println(cache);
        int firstKey = cache.iterator().next();
        cache.remove(firstKey);
        System.out.println(cache);
        int a[][] = {{1, -3},
                {1, 4},
                {3, 5},
                {2, 1},
                {3, 5},
                {1, 11}};
        System.out.println(minTotalDistance(a));*/

        //System.out.println(binaryPatternMatching("00","aaaaaaaaaa"));
        /*String s = null;
        try {
            s = s.indexOf("test2");
        } catch (Exception e) {
            s = "test";
            return s;
        } finally {
            s="abc";
            return s;
        }*/
    }


    static int binaryPatternMatching(String pattern, String s) {
        String binaryString = convertToBinary(s);
        System.out.println(binaryString);
        int matchCounter = 0;
        int patternLength = pattern.length();
        int binaryStringLength = binaryString.length();
        for(int index=0; index<patternLength-1; index++){
            System.out.println(binaryString.substring(index, index+patternLength));
            System.out.println(pattern);
            if((binaryString.substring(index, index+patternLength)).equals(pattern)){
                matchCounter++;
            }
        }
        return matchCounter;
    }

    static String convertToBinary(String source){
        String vowels = "aeiou";
        int len = source.length();
        StringBuilder binaryStr = new StringBuilder();
        for(int index = 0 ; index<len; index++){
            if(vowels.contains(source.charAt(index)+"")){
                binaryStr.append("0");
            }else{
                binaryStr.append("1");
            }
        }
        return binaryStr.toString();
    }

    public static int minTotalDistance(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        ArrayList<Integer> cols = new ArrayList<Integer>();
        ArrayList<Integer> rows = new ArrayList<Integer>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    cols.add(j);
                    rows.add(i);
                }
            }
        }

        int sum=0;

        for(Integer i: rows){
            sum += Math.abs(i - rows.get(rows.size()/2));
        }

        Collections.sort(cols);

        for(Integer i: cols){
            sum+= Math.abs(i-cols.get(cols.size()/2));
        }

        return sum;
    }
}