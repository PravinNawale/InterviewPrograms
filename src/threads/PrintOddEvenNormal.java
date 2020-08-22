package threads;

public class PrintOddEvenNormal {

	public static void main(String[] args) {
		PrintOddEven object = new PrintOddEven();
		
		Thread oddThread = new Thread("Odd") {
			@Override
			public void run() {
				object.printOddNumber();
			}
		};
		Thread evenThread = new Thread("Even") {
			@Override
			public void run() {
				object.printEvenNumber();
			}
		};

		evenThread.start();
		oddThread.start();
	}
}

class PrintOddEven {

	private int maxLimit = 20;

	public void printOddNumber() {
		synchronized (this) {
			for (int i = 1; i <= maxLimit; i = i + 2) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
				notifyAll();
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			notifyAll();
		}
	}

	public void printEvenNumber() {
		synchronized (this) {
			for (int i = 0; i <= maxLimit; i = i + 2) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
				notifyAll();
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			notifyAll();
		}
	}
}
