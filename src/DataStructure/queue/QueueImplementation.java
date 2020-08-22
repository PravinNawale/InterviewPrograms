package DataStructure.queue;

import java.util.Arrays;

/*
 * Circular Queue Implementation using fixed length Array
 */
public class QueueImplementation {

	public static void main(String[] args) {
		MyQueue<String> queue = new MyQueue<String>();
		queue.enQueue("1");
		queue.enQueue("3");
		System.out.println(queue);
		queue.deQueue();
		System.out.println(queue);
		queue.deQueue();
		System.out.println(queue.isEmpty());
	}
}

class MyQueue<T> {

	private int length = 0;
	private int initialCapacity = 10;
	private Object[] myArray;
	private int front = 0;
	private int rear = 0;

	public MyQueue() {
		myArray = new Object[initialCapacity];
	}

	public MyQueue(int customSize) {
		initialCapacity = customSize;
		myArray = new Object[initialCapacity];
	}

	public void enQueue(T item) {
		if (length == initialCapacity) {
			throw new RuntimeException("Queue is full!");
		} else {
			length++;
			myArray[rear] = item;
			rear = (rear + 1) % initialCapacity;
		}
	}

	public T deQueue() {
		T obj;
		if(length == 0) {
			throw new RuntimeException("Queue is Empty");
		}
		else {
			length--;
			obj = (T) myArray[ front % initialCapacity];
			myArray[front] = Integer.MIN_VALUE;
			front = (front+1) % initialCapacity;
		}
		return obj;
	}

	public boolean isEmpty() {
		return (length == 0);
	}
	
	public boolean contains(T item) {
		return (Arrays.asList(myArray).contains(item));
	}
	
	public boolean isFull() {
		return (length == initialCapacity);
	}

	public int size() {
		return length;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[ ");
		for(int i=0;i<length;i++) {
			builder.append(myArray[(front+i)%initialCapacity]+" ");
		}
		builder.append(" ]");
		return builder.toString();
	}
}
