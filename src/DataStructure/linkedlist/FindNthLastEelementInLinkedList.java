package DataStructure.linkedlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class FindNthLastEelementInLinkedList {

	public static void main(String[] args) {
		
		int nthElement = 3;
		
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		linkedlist.add(2);
		linkedlist.add(53);
		linkedlist.add(6);
		linkedlist.add(8);
		linkedlist.add(32);
		linkedlist.add(64);
		linkedlist.add(27);
		linkedlist.add(34);
		linkedlist.add(83);
		
		ArrayList<Integer> elements = new ArrayList<Integer>();
		for(int i=0;i<linkedlist.size();i++) {
			elements.add(linkedlist.get(i));
		}
		
		System.out.println("nthElement is :=>"+elements.get(elements.size()-nthElement));

	}

}
