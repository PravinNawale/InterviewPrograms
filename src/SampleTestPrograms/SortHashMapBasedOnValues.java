package SampleTestPrograms;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortHashMapBasedOnValues {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("1", "Pravin");
		map.put("4", "Sushant");
		map.put("5", "Somnath");
		map.put("2", "Amit");
		map.put("9", "Ronit");
		System.out.println("HashMap Values:=>" + map);
		
		List<Map.Entry<String, String>> mapEntryList = new LinkedList<Entry<String, String>>(map.entrySet());
		Collections.sort(mapEntryList, new Comparator<Map.Entry<String, String>>() {
			@Override
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
		Map<String, String> sortedMap = new LinkedHashMap<String, String>();
		mapEntryList.forEach(entry -> {
			sortedMap.put(entry.getKey(), entry.getValue());
		});
		System.out.println("HashMap Values sortedMap:=>" + sortedMap);
	}
}
