package thread.concurrentHashmap;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
	public static void main(String args[]) {
		// ConcurrentHashMap
		Map<String,String> concurrentMap = new ConcurrentHashMap<String,String>();
		concurrentMap.put("1", "1");
		concurrentMap.put("2", "1");
		concurrentMap.put("3", "1");
		concurrentMap.put("4", "1");
		concurrentMap.put("5", "1");
		concurrentMap.put("6", "1");
		System.out.println("ConcurrentHashMap before iterator: " + concurrentMap);
		Iterator<String> it = concurrentMap.keySet().iterator();

		while (it.hasNext()) {
			String key = it.next();
			if (key.equals("3"))
				concurrentMap.put(key + "new", "new3");
		}
		System.out.println("ConcurrentHashMap after iterator: " + concurrentMap);
	}
}
