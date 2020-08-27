package company.avira;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EvenWord {
    public static void main(String[] args) {
        int result = numberOfLettersToBeRemoved("axxaxa");
        System.out.println("Result:=>" + result);
    }

    public static int numberOfLettersToBeRemoved(String input) {
        int result = 0;
        Map<Character, Integer> mapCount = new HashMap<>();
        for(int i=0; i < input.length(); i++){
            if(mapCount.containsKey(input.charAt(i))) {
                mapCount.put(input.charAt(i), mapCount.get(input.charAt(i))+1);
            } else {
                mapCount.put(input.charAt(i), 1);
            }
        }
        Iterator iterator = mapCount.values().iterator();
        while(iterator.hasNext()) {
            if((Integer)iterator.next() % 2 != 0){
                result++;
            }
        }
        return result;
    }
}
