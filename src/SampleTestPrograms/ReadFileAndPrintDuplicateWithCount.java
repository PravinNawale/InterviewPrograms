package SampleTestPrograms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;

public class ReadFileAndPrintDuplicateWithCount {

	private static BufferedReader br;

	public static void main(String[] args) throws Exception {
		File file = new File("C:\\Users\\pbah\\Downloads\\My Updated Resume\\Interview Preparations\\Data Structure Questions.txt");
		FileReader reader = new FileReader(file);
		br = new BufferedReader(reader);
		String line = br.readLine();
		HashMap<String,Integer> countMap = new HashMap<String,Integer>();
		while(line!=null) {
			line = br.readLine();
			if(line!=null) {
				String[] words = line.split(" ");
				for(int i=0;i<words.length;i++) {
					if(countMap.containsKey(words[i])) {
						countMap.put(words[i],countMap.get(words[i])+1);
					}else {
						countMap.put(words[i],1);
					}
				}
			}
		}
		System.out.println(""+countMap);
		//Print all those whose count is more than 1
	}
}
