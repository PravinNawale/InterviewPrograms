package SampleTestPrograms;

import java.util.HashMap;
import java.util.Map;

public class OutOFMemorySample {

	public static void main(String[] args) {
		while(true) {
			Map<Integer, String> map = new HashMap<Integer, String>();
			map.put(1, "asfafasfafasfasfafafafaaf");
			System.out.println("Free Memory:=>" + Runtime.getRuntime().freeMemory());
		}
	}

}

/* For Annotation 
 * 
 */
@interface Test {

}