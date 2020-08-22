package threads;

public class PrintMessagesWithoutUsingJoin {

	public static void main(String[] args) throws InterruptedException {
		String[] messages = { "I", "Am", "Pravin" };
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(messages[0]);
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					t1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(messages[1]);
			}
		});

		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					t2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(messages[2]);
			}
		});

		t3.start();
		t2.start();
		t1.start();

	}
}
