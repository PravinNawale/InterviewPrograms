package SampleTestPrograms;

public class OwnMathPowerFunction {
    public static void main(String[] args) {
        double result = power(2, 4);
        System.out.println("Result:=>" + result);
    }

    public static double power(double base, int power) {
        if(power == 0)
            return 1;
        double temp = power(base, power/2);
        if (power % 2 == 0)
            return temp * temp;
        else
            return base * temp * temp;
    }
}
