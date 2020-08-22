package SampleTestPrograms;

import java.util.HashMap;
import java.util.Iterator;

public class ImmutableClassExample {

}

final class Employee {
	
	private final int employeeID;
	private final String employeeName;
	private final HashMap<String,String> testMap;
	
	/**
	 * Constructor performing Deep Copy
	 * @param i
	 * @param n
	 * @param hm
	 */
	public Employee(int employeeID, String employeeName,HashMap<String,String> testMap) {
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		HashMap<String,String> tempMap = new HashMap<String,String>();
		String key;
		Iterator<String> it = testMap.keySet().iterator();
		while(it.hasNext()){
			key = it.next();
			tempMap.put(key, testMap.get(key));
		}
		this.testMap = tempMap;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	
	public String getEmployeeName() {
		return employeeName;
	}
	
	public HashMap<String, String> getTestMap() {
		//return testMap;
		return (HashMap<String, String>) testMap.clone();
	}
	
}
