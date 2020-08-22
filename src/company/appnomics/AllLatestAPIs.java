package company.appnomics;

import java.io.*;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class AllLatestAPIs {
    public static void main(String[] args) throws Exception {
		AllLatestAPIs main = new AllLatestAPIs();
		TreeMap<String, Integer> appApiCount = main.getLatestAPIsApp("input.txt");
		main.writeLatestApps("output.txt", appApiCount);
    }

	private TreeMap<String, Integer> getLatestAPIsApp(final String inputFile) throws Exception {
    	if(inputFile.isEmpty()) {
    		throw new Exception("File name can not be empty or null");
		}
        HashMap<String, Integer> apiVersions = new HashMap<String, Integer>();
        TreeMap<String, Integer> appApiCount = new TreeMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(inputFile)))) {
			String currentLine = reader.readLine();
			while (currentLine != null) {
				String[] data = currentLine.split(",");
				String appName = data[0];
				String apiName = data[1];
				Integer apiVersion = Integer.parseInt(data[2].trim().substring(1));
				if (apiVersions.containsKey(apiName)) {
					if (apiVersion > apiVersions.get(apiName)) {
						apiVersions.put(apiName, apiVersion);
					}
					if (apiVersion == apiVersions.get(apiName)) {
						if (!appApiCount.containsKey(appName)) {
							appApiCount.put(appName, 1);
						} else {
							appApiCount.put(appName, 1 + appApiCount.get(appName));
						}
					} else {
						appApiCount.put(appName, 0);
					}
				} else {
					apiVersions.put(apiName, apiVersion);
				}
				currentLine = reader.readLine();
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		return appApiCount;
    }

    private void writeLatestApps(final String outputFile, final TreeMap<String, Integer> appApiCount) throws Exception {
		if(outputFile.isEmpty()) {
			throw new Exception("File name can not be empty or null");
		}
    	Set<String> keys = appApiCount.keySet();
		String app_name = "";
		Integer tempCount = 0;
		for (String string : keys) {
			if (appApiCount.get(string) > tempCount) {
				tempCount = appApiCount.get(string);
				app_name = string;
			}
		}
		try(PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)))) {
			output.println("" + app_name);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
}
