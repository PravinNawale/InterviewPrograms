package DataStructure.linkedlist;

import java.util.LinkedList;
import java.util.Stack;

public class ReverseLinkedListUptoKElement {

	public static void main(String[] args) {
		int k = 2;
		LinkedList<String> sampleLinkedList = new LinkedList<String>();
		sampleLinkedList.add("3");
		sampleLinkedList.add("2");
		sampleLinkedList.add("1");
		sampleLinkedList.add("5");
		sampleLinkedList.add("7");
		System.out.println("Original LinkedList:=>"+sampleLinkedList);
		Stack<String> temp = new Stack<String>(); //You can use a simple Array As well
		for(int i=0;i<=k;i++) {
			temp.push(sampleLinkedList.removeFirst());
		}
		for(int j=0;j<=k;j++) {
			sampleLinkedList.addFirst(temp.elementAt(j));
		}
		System.out.println("Reversed LinkedList:=>"+sampleLinkedList);
	}

}
