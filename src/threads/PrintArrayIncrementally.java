package threads;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintArrayIncrementally {

	public static void main(String[] args) {

		String arr[] = { "2", "5", "6", "1", "3", "8", "0", "10", "3", "1" };
		AtomicInteger count = new AtomicInteger(0);
		final Thread t1 = new Thread("Thread 1") {
			@Override
			public void run() {
				synchronized (arr) {
					while (count.get() < arr.length) {
						System.out.println(Thread.currentThread().getName() + ":" + arr[count.get()]);
						arr.notify();
						try {
							arr.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					arr.notify();
				}
			}
		};

		final Thread t2 = new Thread("Thread 2") {
			@Override
			public void run() {
				synchronized (arr) {
					while (count.get() < arr.length) {
						System.out.println(Thread.currentThread().getName() + ":" + arr[count.getAndIncrement()]);
						arr.notify();
						try {
							arr.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					arr.notify();
				}
			}
		};

		t1.start();
		t2.start();
	}
}

/*
Output:
Thread 1:2
Thread 2:2
Thread 1:5
Thread 2:5
Thread 1:6
Thread 2:6
Thread 1:1
Thread 2:1
Thread 1:3
Thread 2:3
Thread 1:8
Thread 2:8
Thread 1:0
Thread 2:0
Thread 1:10
Thread 2:10
Thread 1:3
Thread 2:3
Thread 1:1
Thread 2:1
 */
