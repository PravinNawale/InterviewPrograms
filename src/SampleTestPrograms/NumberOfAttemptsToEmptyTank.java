package SampleTestPrograms;

/*
    Given a container of water which is having 100 liter of water, in first attempt will remove 1 % water in 2nd attempt will remove 2% water how many attempt are required to completely empty the container.
*/
public class NumberOfAttemptsToEmptyTank {
    public static void main(String[] args) {
        int totalWater = 100;
        int initialPercentage = 1;
        while(totalWater > 0) {
            int waterRemoved = (initialPercentage/totalWater)*100;
            System.out.println("WaterRemoved:=>" + waterRemoved);
            totalWater = totalWater - waterRemoved;
            System.out.println("totalWater:=>" + totalWater);
            System.out.println("Attempt: " + initialPercentage + " Water Removed:" + waterRemoved + " Water Remaining:" + totalWater);
            initialPercentage++;
        }
    }
}
