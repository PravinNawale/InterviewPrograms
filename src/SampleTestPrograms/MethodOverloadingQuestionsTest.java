package SampleTestPrograms;

public class MethodOverloadingQuestionsTest {

	public static void main(String[] args) {
		print(null);
	}
	
	/*public static void print(Integer integer) {
		System.out.println("Integer Called: "+integer);
	}*/
	
	public static void print(String str) {
		System.out.println("String Called: "+str);
	}
	
	public static void print(Object obj) {
		System.out.println("Object Called: "+obj);
	}
}
