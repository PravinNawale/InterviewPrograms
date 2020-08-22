package thread.producerconsumerexamples;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerArrayBlockingQueue {

	public static void main(String args[]) {
		BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(5);

		Producer producer = new Producer(blockingQueue);
		Consumer consumer = new Consumer(blockingQueue);

		new Thread(producer).start();
		new Thread(consumer).start();
	}
}

class Producer implements Runnable {

	protected BlockingQueue<Integer> queue = null;

	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				queue.put(i);
				System.out.println("Produced: " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			queue.put(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Consumer implements Runnable {

	protected BlockingQueue<Integer> queue = null;

	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			while (queue.take() != 100) {
				System.out.println("Consumed: " + queue.take());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}