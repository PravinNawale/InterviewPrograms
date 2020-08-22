package SampleTestPrograms;

public class SMSSpliter {

	public static void main(String[] args) {
		
		String message = "As a member of our Software Engineering Group you will dive head-first into creating innovative solutions that advance businesses and careers our Software Engineering Group";
		
		int totalChunkCount = 0;
		int totalChunkLength = (30-5);
		while(message.length()>totalChunkLength) {
			String subValue = message.substring(0, totalChunkLength);
			int lastIndexOftemp = subValue.lastIndexOf(" ");
			if(lastIndexOftemp<subValue.length()) {
				//Word Spiting is happening
				subValue = message.substring(0,subValue.lastIndexOf(" "));
				message = message.substring(lastIndexOftemp);
			}else {
				message = message.substring(totalChunkLength);
			}
			totalChunkCount++;
		}
		if(message.length()<totalChunkLength) {
			totalChunkCount++;
		}
		
		System.out.println(totalChunkCount);
	}

}
