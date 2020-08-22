package SampleTestPrograms;

import java.io.File;

public class GetFileAndFoldersCount {
	public static void main(String[] args) {
		int filesCount = 0;
		int foldersCount = 0;

		File f = new File("C:\\Users\\pbah\\Downloads");
		File[] files = f.listFiles();
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				if (file.isDirectory()) {
					foldersCount++;
				} else {
					filesCount++;
				}
			}
		}
		System.out.println("File Count:=>"+filesCount);
		System.out.println("Folder Count:=>"+foldersCount);
	}
}
