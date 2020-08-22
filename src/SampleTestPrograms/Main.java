package SampleTestPrograms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		String line = br.readLine();
		HashMap<String,Integer> apivsVersions = new HashMap<String,Integer>();
		while(line!=null) {
			String[] data = line.split(",");
			String apiName = data[1];
			Integer apiVersion = Integer.parseInt(data[2].trim().substring(1));
			if(apivsVersions.containsKey(apiName)) {
				if(apiVersion>apivsVersions.get(apiName));
					apivsVersions.put(apiName, apiVersion);
			} else {
				apivsVersions.put(apiName, apiVersion);
			}
			line = br.readLine();
		}
		br.close();
		TreeMap<String,Integer> map = new TreeMap<>();
		br = new BufferedReader(new FileReader(new File("input.txt")));
		line = br.readLine();
		while(line!=null) {
			String[] data = line.split(",");
			String appName = data[0];
			String apiName = data[1];
			Integer apiVersion = Integer.parseInt(data[2].trim().substring(1));
			if(apiVersion == apivsVersions.get(apiName)) {
				if(!map.containsKey(appName)) {
					map.put(appName, 1);
				} else {
					map.put(appName, 1 + map.get(appName));
				}
			} else {
				map.put(appName, 0);
			}
			line = br.readLine();
		}
		br.close();
		Set<String> keys = map.keySet();
		String app_name = "";
		Integer temp = 0;
		for (String string : keys) {
			if(map.get(string)>temp) {
				temp = map.get(string);
				app_name = string;
			}
		}
		PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
        output.println("" + app_name);
        output.close();
	}
}
