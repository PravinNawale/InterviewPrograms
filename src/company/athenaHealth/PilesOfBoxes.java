package company.athenaHealth;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class PilesOfBoxes {
    /*
        Alexa is given n piles of equal or unequal heights. In one step, Alexa can remove any number of boxes from the pile
        which has the maximum height and try to make it equal to the one which is just lower than the maximum height of the
        stack. Determine the minimum number of steps required to make all of the piles equal in height.
        Input: piles = [5, 2, 1]
        Output: 3
        Explanation:
        Step 1: reducing 5 -> 2 [2, 2, 1]
        Step 2: reducing 2 -> 1 [2, 1, 1]
        Step 3: reducing 2 -> 1 [1, 1, 1]
        So final number of steps required is 3.
     */
    public static void main(String[] args) {
        int[] pilesStacks1 = {5, 2, 1};
        System.out.println(minSteps(pilesStacks1));
        int[] pilesStacks2 = {843, 247};
        System.out.println(minSteps(pilesStacks2));
        int[] pilesStacks3 = {2};
        System.out.println(minSteps(pilesStacks3));
    }

    public static int minSteps(int[] input) {
        int res = 0;
        // Creating a Map like: {80=1, 210=2, 150=1, 110=1}
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : input) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        // System.out.println(map);
        // So basically we are creating the maxHeap over hear using the customer comparator based on the key(height of piles)
        // There is a possibility that few piles can be of same height so it means we have to perform same operation twice
        // Hence instead of doing it twice we are keeping the counter as i.e.2 now when we want to match the next piles we might remove
        // n boxes but the idea still remains the same like we will 2 removal ones and so on consecutive piles to match.
        // So in the end there will be a  last piles weather we don't need to do independent removal and hence the final count we return.
        // Time complexity: O(nLogn)

        Queue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        maxHeap.addAll(map.entrySet());
        System.out.println(maxHeap);
        while(maxHeap.size() > 1) {
            Map.Entry<Integer, Integer> entry1 = maxHeap.poll();
            System.out.println("entry1:=>" + entry1);
            Map.Entry<Integer, Integer> entry2 = maxHeap.poll();
            System.out.println("entry2:=>" + entry2);
            res = res + entry1.getValue();
            entry2.setValue(entry2.getValue() + entry1.getValue());
            maxHeap.offer(entry2);
            System.out.println(maxHeap);
        }
        return res;
    }
}
