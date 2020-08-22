package SampleTestPrograms;

import java.util.LinkedHashMap;
import java.util.Map;

/*
Given an input string, write a function that returns the Run Length Encoded string for the input string.
For example, if the input string is “wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6”
*/
public class RunLengthEncoding {

    public static void main(String[] args) {
        String input = "wwwwaaadexxxxxx";
        Map<String, Integer> encodingMap = new LinkedHashMap<>();
        for(int i=0; i<input.length(); i++) {
            String character = input.charAt(i) + "";
            if(!encodingMap.containsKey(character)){
                encodingMap.put(character, 1);
            } else {
                encodingMap.compute(character, (s, integer) -> integer + 1);
            }
        }
        System.out.println("Map:=> " + encodingMap);
        encodingMap.keySet().forEach(key -> {
            System.out.print(key + encodingMap.get(key));
        });
    }
}
