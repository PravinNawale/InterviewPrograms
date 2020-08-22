package threads;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintListUsing6Threads {

	public static void main(String[] args) {
		List<String> names = new CopyOnWriteArrayList<String>();
		names.add("1");
		names.add("2");
		names.add("3");
		names.add("4");
		names.add("5");
		names.add("6");
		names.add("7");
		names.add("8");
		names.add("9");
		names.add("10");
		names.add("11");
		names.add("12");
		AtomicInteger counter = new AtomicInteger(0);

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (names) {
					while (true && counter.get()<names.size()) {
						System.out.println("Thread 1: " + names.get(counter.getAndIncrement()));
						names.notify();
						try {
							Thread.sleep(1000);
							names.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					names.notify();
				}
			}
		});
		t1.start();

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (names) {
					while (true && counter.get()<names.size()) {
						System.out.println("Thread 2: " + names.get(counter.getAndIncrement()));
						names.notify();
						try {
							Thread.sleep(1000);
							names.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					names.notify();
				}
			}
		});
		t2.start();

		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (names) {
					while (true && counter.get()<names.size()) {
						System.out.println("Thread 3: " + names.get(counter.getAndIncrement()));
						names.notify();
						try {
							Thread.sleep(1000);
							names.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					names.notify();
				}
			}
		});
		t3.start();

		Thread t4 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (names) {
					while (true && counter.get()<names.size()) {
						System.out.println("Thread 4: " + names.get(counter.getAndIncrement()));
						names.notify();
						try {
							Thread.sleep(1000);
							names.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					names.notify();
				}
			}
		});
		t4.start();

		Thread t5 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (names) {
					while (true && counter.get()<names.size()) {
						System.out.println("Thread 5: " + names.get(counter.getAndIncrement()));
						names.notify();
						try {
							Thread.sleep(1000);
							names.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					names.notify();
				}
			}
		});
		t5.start();

		Thread t6 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (names) {
					while (true && counter.get()<names.size()) {
						System.out.println("Thread 6: " + names.get(counter.getAndIncrement()));
						names.notify();
						try {
							Thread.sleep(1000);
							names.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					names.notify();
				}
			}
		});
		t6.start();
	}
}
