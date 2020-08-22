package SampleTestPrograms;

public class ReverseSentenceWithWords {

	public static void main(String[] args) {
		String s = "I live in India";
		String[] split = s.split(" ");
		String result = "";
		for (int i = split.length - 1; i >= 0; i--) {
		  result += (split[i] + " ");
		}
		System.out.println(result.trim());

		for(int i=s.length()-1;i>=0;i--) {
			System.out.print(s.charAt(i));
		}
	}
}
