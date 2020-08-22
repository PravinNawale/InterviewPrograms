package SampleTestPrograms;

/*
 * We can refer static fields in non-static methods. True or false? - True
 */
public class StaticFieldsInNonStaticMethods {
	private static int test = 1;
	public static void main(String[] args) {
		test = 4;
	}
	
	private void testPrint() {
		System.out.println("test value:=>" + test);
	}

}
