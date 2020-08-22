package SampleTestPrograms;

import java.util.HashSet;
import java.util.Set;

public class ProgramToPrintAllPermutations {
    public static void main(String[] args) {
        Set<String> combinations = new HashSet<String>();
        String input = "ABCD";
        int rotateCount = 1;
        for(int i=0;i<input.length();i++) {
            String combination = input.charAt(i)+"";
            for(int j=0; j<input.length();j++) {
                if(input.charAt(j) != input.charAt(i)){
                    combination = combination + input.charAt(j);
                }
            }
            if( i == input.length()-1 && rotateCount != input.length()) {
                i=0;
                rotateCount++;
                input = rotateString(input);
            }
            combinations.add(combination);
        }
        System.out.println("All combinations:=>"+ combinations);
    }

    public static String rotateString(String input) {
        String rotatedString = input.charAt(input.length()-1) + input.substring(0,input.length()-1);
        return rotatedString;
    }
}
