package SampleTestPrograms;

public class CheckIfArrayIsSorted {

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 5, 4};
        for(int i=0; i< numbers.length - 1; i++) {
            int first = numbers[i];
            int second = numbers[i+1];
            if(second < first) {
                System.out.print("Array is not Sorted.!");
                break;
            }
            first++;
            second++;
        }
    }
}
