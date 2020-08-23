package company.twillio;

import java.util.*;

/*
    Program: https://leetcode.com/discuss/interview-question/609179/twilio-oa-2020
*/
public class VanityNumberSearch {
    public static void main(String[] args) {
        final Map<Character, Character> characterToNumberMap = new HashMap<>();
        characterToNumberMap.put('A', '2');
        characterToNumberMap.put('B', '2');
        characterToNumberMap.put('C', '2');
        characterToNumberMap.put('D', '3');
        characterToNumberMap.put('E', '3');
        characterToNumberMap.put('F', '3');
        characterToNumberMap.put('G', '4');
        characterToNumberMap.put('H', '4');
        characterToNumberMap.put('I', '4');
        characterToNumberMap.put('J', '5');
        characterToNumberMap.put('K', '5');
        characterToNumberMap.put('L', '5');
        characterToNumberMap.put('M', '6');
        characterToNumberMap.put('N', '6');
        characterToNumberMap.put('O', '6');
        characterToNumberMap.put('P', '7');
        characterToNumberMap.put('Q', '7');
        characterToNumberMap.put('R', '7');
        characterToNumberMap.put('S', '7');
        characterToNumberMap.put('T', '8');
        characterToNumberMap.put('U', '8');
        characterToNumberMap.put('V', '8');
        characterToNumberMap.put('W', '9');
        characterToNumberMap.put('X', '9');
        characterToNumberMap.put('Y', '9');
        characterToNumberMap.put('Z', '9');
        final List<String> vanityCodes = Arrays.asList("TWLO");
        final List<String> phoneNumbers = Arrays.asList("+14157088956", "+15108956333", "+1415123456", "+17474824380", "+919810155555");
        final List<String> nameToNum = new ArrayList();
        for(int index = 0; index < vanityCodes.size(); index++){
            String current = vanityCodes.get(index);
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < current.length(); j++){
                sb.append(characterToNumberMap.get(current.charAt(j)));
            }
            nameToNum.add(sb.toString());
        }
        final List<String> output = new ArrayList<>();
        for(int index = 0; index < nameToNum.size(); index++){
            output.addAll(findMatch(nameToNum.get(index), phoneNumbers));
        }
        Collections.sort(output);
        for(String str: output){
            System.out.println(str);
        }
    }

    public static Set<String> findMatch(String find, List<String> numbers){
        final Set<String> output = new HashSet<>();
        for(int index = 0; index < numbers.size(); index++){
            if(numbers.get(index).contains(find)){
                output.add(numbers.get(index));
            }
        }
        return output;
    }
}
