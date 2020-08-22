package company.microsoft;

public class PrintBinaryRepresentation {

	public static void main(String[] args) {
		bin(7); 
	    System.out.println(); 
	    bin(4);
	}
	
	static void bin(int n) 
	{
		//System.out.print("Number:=>"+n);
	    /* step 1 */
	    if (n > 1) 
	        bin(n/2); 
	  
	    /* step 2 */
	    System.out.print(n % 2); 
	} 
}
