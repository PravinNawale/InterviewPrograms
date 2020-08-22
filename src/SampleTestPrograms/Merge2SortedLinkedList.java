package SampleTestPrograms;

import java.util.LinkedList;

public class Merge2SortedLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(0);
        list1.add(11);
        list1.add(12);
        list1.add(32);
        list1.add(54);

        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(3);
        list2.add(44);
        list2.add(55);
        list2.add(100);
        list2.add(633);

        mergeLinkedLists(list1, list2);
    }

    public static void mergeLinkedLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {

    }
}
