package DataStructure.linkedlist;

public class SinglyLinkedListMain {
	
	public static void main(String args[]) {
		SLinkedList<String> linkedList = new SLinkedList<String>();
		linkedList.insertAtFirst("1");
		linkedList.insertAtFirst("5");
		linkedList.insertAtFirst("3");
		linkedList.insertAtLast("1234");
		System.out.println(linkedList);
		linkedList.deleteAtFirst();
		linkedList.deleteAtLast();
		System.out.println(linkedList);
	}
}

class SLinkedList<T> {

	private int length = 0;
	private LinkedNode<T> head;

	public synchronized void insertAtFirst(T data) {
		LinkedNode<T> node = new LinkedNode<T>(data);
		node.setNext(head);
		head = node;
		length++;
	}

	public synchronized void insertAtLast(T data) {
		LinkedNode<T> node = new LinkedNode<T>(data);
		if (head == null) {
			head = node;
		} else {
			LinkedNode<T> temp = head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(node);
		}
		length++;
	}
	
	public LinkedNode<T> getHead() {
		return head;
	}

	public synchronized void insertAtIndex(T data, int index) {
		if (index < 0) {
			index = 0;
		}
		if (index > length) {
			index = length;
		}
		if (head == null) {
			head = new LinkedNode<T>(data);
		} else if (index == 0) {
			LinkedNode<T> node = new LinkedNode<T>(data);
			node.setNext(head);
			head = node;
		} else {
			LinkedNode<T> temp = head;
			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
			}
			LinkedNode<T> node = new LinkedNode<T>(data);
			node.setNext(temp.getNext());
			temp.setNext(node);
		}
		length++;
	}

	public synchronized LinkedNode<T> deleteAtFirst() {
		LinkedNode<T> temp = head;
		if (temp != null) {
			head = temp.getNext();
			temp.setNext(null);
		}
		length--;
		return temp;
	}

	public synchronized LinkedNode<T> deleteAtLast() {
		if (head == null) {
			return null;
		}
		LinkedNode<T> previous = head, next = head.getNext();
		if(next == null) {
			head = null;
			return previous;
		}
		while(next.getNext()!=null) {
			previous = next;
			next = next.getNext();
		}
		previous.setNext(null);
		next = null;
		length--;
	    return previous;
	}

	public synchronized void deleteAtIndex(int index) {
		if (index < 0) {
			deleteAtFirst();
		}
		if (index > length) {
			deleteAtLast();
		} else {
			LinkedNode<T> temp = head;
			for(int i=0;i<index;i++) {
				temp = temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
		}
		length--;
	}

	public int size() {
		int length = 0;
		LinkedNode<T> currentNode = head;
		while (currentNode != null) {
			currentNode = currentNode.getNext();
			length++;
		}
		return length;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[ ");
		LinkedNode<T> temp = head;
		for(int i=0;i<length;i++) {
			builder.append(temp.getData()+", ");
			System.out.println("Node Value:=>"+temp.getData());
			temp = temp.getNext();
		}
		builder.append("]");
		return builder.toString();
	}
}
