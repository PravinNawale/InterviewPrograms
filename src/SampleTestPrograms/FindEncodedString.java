package SampleTestPrograms;

import java.util.ArrayList;
import java.util.HashMap;

public class FindEncodedString {

	private static HashMap<String, String> alpbhabetsEncodingMap = new HashMap<String, String>();
	static {
		alpbhabetsEncodingMap.put("a", "1");
		alpbhabetsEncodingMap.put("b", "2");
		alpbhabetsEncodingMap.put("c", "3");
		alpbhabetsEncodingMap.put("d", "4");
		alpbhabetsEncodingMap.put("e", "5");
		alpbhabetsEncodingMap.put("f", "6");
		alpbhabetsEncodingMap.put("g", "7");
		alpbhabetsEncodingMap.put("h", "8");
		alpbhabetsEncodingMap.put("i", "9");
		alpbhabetsEncodingMap.put("j", "10#");
		alpbhabetsEncodingMap.put("k", "11#");
		alpbhabetsEncodingMap.put("l", "12#");
		alpbhabetsEncodingMap.put("m", "13#");
		alpbhabetsEncodingMap.put("n", "14#");
		alpbhabetsEncodingMap.put("o", "15#");
		alpbhabetsEncodingMap.put("p", "16#");
		alpbhabetsEncodingMap.put("q", "17#");
		alpbhabetsEncodingMap.put("r", "18#");
		alpbhabetsEncodingMap.put("s", "19#");
		alpbhabetsEncodingMap.put("t", "20#");
		alpbhabetsEncodingMap.put("u", "21#");
		alpbhabetsEncodingMap.put("v", "22#");
		alpbhabetsEncodingMap.put("w", "23#");
		alpbhabetsEncodingMap.put("x", "24#");
		alpbhabetsEncodingMap.put("y", "25#");
		alpbhabetsEncodingMap.put("z", "26#");
	}

	public static void main(String[] args) {
		String encodedString = "122(2)21#26#(5)";
		ArrayList<Integer> representation = getRepresentationAfterDecoding(encodedString);
		System.out.println("" + representation);

	}

	private static ArrayList<Integer> getRepresentationAfterDecoding(String encodedString) {
		HashMap<String,Integer> encodedMapCount = new HashMap<String,Integer>();
		for(int i=0;i<encodedString.length();i++) {
			if(encodedString.charAt(i) != '(' && encodedString.charAt(i) != '#' && encodedString.charAt(i) != ')' 
					&& (i+2)<encodedString.length()
					&& encodedString.charAt(i+2) != '(' && encodedString.charAt(i+2) != '#'	) {
				System.out.println("NormalString:=>"+encodedString.charAt(i));
				if(encodedMapCount.containsKey(encodedString.charAt(i)+"")) {
					encodedMapCount.put(encodedString.charAt(i)+"",encodedMapCount.get(encodedString.charAt(i)+"")+1);
				} else {
					encodedMapCount.put(encodedString.charAt(i)+"",1);
				}
			}
			if((i+2)<encodedString.length() && encodedString.charAt(i+2) == '#' ) {
				String hashString = encodedString.substring(i,i+3);
				System.out.println("HashString:=>"+hashString);
				if(encodedString.substring(i+3,i+4) != "(") {
					if(encodedMapCount.containsKey(hashString)) {
						encodedMapCount.put(hashString,encodedMapCount.get(hashString)+1);
					} else {
						encodedMapCount.put(hashString,1);
					}
					i = i+1;
				}
			}
			if((i+2)<encodedString.length() && encodedString.charAt(i+2) == '(') {
				String paraString = encodedString.substring(i+1,i+5);
				System.out.println("ParaString:=>"+paraString);
				if(paraString.startsWith("#")) {
					String cornerCase = encodedString.substring(i-1,i+5);
					System.out.println("cornerCase:=>"+cornerCase);
					if(encodedMapCount.containsKey(cornerCase.substring(0,3))) {
						System.out.println("test:=>"+cornerCase.substring(4,5));
						encodedMapCount.put(cornerCase.substring(0,3),encodedMapCount.get(cornerCase.substring(0,3))+Integer.parseInt(cornerCase.substring(4,5)));
					} else {
						encodedMapCount.put(encodedString.charAt(i+1)+"",Integer.parseInt(encodedString.charAt(i+3)+""));
					}
				} else {
					if(encodedMapCount.containsKey(encodedString.charAt(i+1)+"")) {
						encodedMapCount.put(encodedString.charAt(i+1)+"",encodedMapCount.get(encodedString.charAt(i+1)+"")
								+Integer.parseInt(encodedString.charAt(i+3)+""));
					} else {
						encodedMapCount.put(encodedString.charAt(i+1)+"",Integer.parseInt(encodedString.charAt(i+3)+""));
					}
				}
				i = i+1;
			}
		}
		System.out.println("Map:=>"+encodedMapCount);
		return null;
	}
}
