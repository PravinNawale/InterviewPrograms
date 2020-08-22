package thread.producerconsumerexamples;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumerNormal {
	public static void main(String args[]) {
		System.out.println("How to use wait and notify method in Java"); 
		System.out.println("Solving Producer Consumper Problem"); 
		Queue<Integer> buffer = new LinkedList<>();
		int maxSize = 10; 
		Thread  producer = new Thread(new ProducerNormal(buffer, maxSize, "PRODUCER")); 
		Thread  consumer = new Thread(new ConsumerNormal(buffer, maxSize, "CONSUMER")); 
		producer.start(); 
		consumer.start();
	}
}

class ProducerNormal implements Runnable {
	private Queue<Integer> queue;
	private int maxSize;
	
	public ProducerNormal(Queue<Integer> queue, int maxSize,String name) {
		super();
		this.queue = queue;
		this.maxSize = maxSize;
	}
	@Override
	public void run() {
		while (true) {
			synchronized (queue) {
				while (queue.size() == maxSize) { 
					try { 
						System.out .println("Queue is full, " + "Producer thread waiting for " + "consumer to take something from queue"); 
						queue.wait(); 
					} catch (Exception ex) { 
						ex.printStackTrace(); 
					} 
				}
				Random random = new Random(); 
				int i = random.nextInt(); 
				System.out.println("Producing value : " + i); 
				queue.add(i);
				queue.notify();
			}
		}
	}
}

class ConsumerNormal implements Runnable {
	private Queue<Integer> queue;
	private int maxSize;
	
	public ConsumerNormal(Queue<Integer> queue, int maxSize,String name) {
		super();
		this.queue = queue;
		this.maxSize = maxSize;
	}
	@Override
	public void run() {
		while (true) { 
			synchronized (queue) { 
				while (queue.isEmpty()) { 
					System.out.println("Queue is empty," + "Consumer thread is waiting" + " for producer thread to put something in queue"); 
					try { 
						queue.wait(); 
					} catch (Exception ex) { 
						ex.printStackTrace(); 
					} 
				} 
				System.out.println("Consuming value : " + queue.remove()); 
				queue.notifyAll(); 
				} 
			}
	}
}