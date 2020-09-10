package company.kForce;

/*
    https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 */
public class SubtractProductAndSum {
    public static void main(String[] args) {
        int result = subtractProductAndSum(234);
        System.out.println(result);
    }

    public static int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while(n != 0){
            int rem = n % 10; //234 = 4
            sum = sum + rem;
            product = product * rem;
            n = n/10;
        }
        return product - sum;
    }
}
